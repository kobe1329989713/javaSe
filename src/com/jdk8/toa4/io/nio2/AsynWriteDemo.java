package com.jdk8.toa4.io.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by kobe on 2019/6/17.20:07
 *
 * @author kobe
 * <br/>
 * Description:
 * 异步IO
 *
 *
异步，你要执行某个操作很费时，而又不能让主线程等待在那里，所以要异步。
等它处理完了，通知我来处理结果就行。我就可以继续干其它事件

对应的代码是怎么实现呢？ *
看 1、2、3、步骤
重点：回调。

AsynchronousFileChannel 它不需要你开启线程。就能异步操作。

 * *
 */
public class AsynWriteDemo {

    private static class Attachment{
        public Path path;
        public ByteBuffer buffer;
        public AsynchronousFileChannel channel;
    }


    // 2、它就是，它异步读取完了，通知我来处理结果。
    // 它是一个回调的实例，所以这两个方法会在异步操作成功或者失败时调用。
    private static class WriteHandler implements CompletionHandler<Integer, Attachment> {
        // 写操作完成之后，就会调用它。
        @Override
        public void completed(Integer result, Attachment attachment) {
            System.out.println("通知我来处理结果了？");

            // 就是那个 a 传递进来的。
            // 如，在完成之后把通道关闭。
            //System.out.println("// 如，在完成之后把通道关闭。");
            try {
                attachment.channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // 在写操作失败时，会执行它。
        @Override
        public void failed(Throwable exc, Attachment attachment) {
            System.out.println("在写操作失败时，会执行它。");
            // 得到执行失败异常信息。
            System.out.println(exc.getMessage());

            try {
                attachment.channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        String path = "D:\\kobe\\xx\\f3.txt";
        Path path1 = Paths.get(path);
        AsynchronousFileChannel afc = AsynchronousFileChannel.open(
                path1,
                StandardOpenOption.WRITE, // 写
                StandardOpenOption.CREATE_NEW  // 创建。
        );

        Attachment a = new Attachment();
        a.buffer = getDate();
        a.path = path1;
        a.channel = afc;

        // 1、这里就是异步的写。
        // 看这个方法的参数，我是如何准备的。
        afc.write(getDate(),0,a,new WriteHandler());
        // 1、模拟这个操作很费时。
        //Thread.sleep(7000);


        System.out.println("3、主线程，它又不能一直等待在这里。主线程可以干其它事件");
        // …………
        // …………
        // …………


    }


    public static ByteBuffer getDate() throws InterruptedException {
        return ByteBuffer.wrap("hello".getBytes());
    }

}
