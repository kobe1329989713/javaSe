package com.jdk8.io.nio2;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by kobe on 2019/6/17.21:14
 *
 * @author kobe
 * <br/>
 * Description:
 * io 的异步读，不需要开启线程的。
 *
 * 先看 写。
 *
 */
public class AsynReadDemo {

    private static class Attachment{
        public Path path;
        public ByteBuffer buffer;
        public AsynchronousFileChannel channel;
    }

    private static class ReadHandler implements CompletionHandler<Integer, Attachment> {
        @Override
        public void completed(Integer result, Attachment attachment) {
            System.out.println("通知我来处理结果了？");

            byte[] data = attachment.buffer.array();
            System.out.println(new String(data));

            try {
                attachment.channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void failed(Throwable exc, Attachment attachment) {
            System.out.println("在写操作失败时，会执行它。");
            System.out.println(exc.getMessage());
        }
    }


    public static void main(String[] args) throws Exception {
        String path = "D:\\kobe\\xx\\f3.txt";
        Path path1 = Paths.get(path);
        AsynchronousFileChannel afc = AsynchronousFileChannel.open(
                path1,
                StandardOpenOption.READ // 读
        );

        ReadHandler handler = new ReadHandler();
        ByteBuffer buffer = ByteBuffer.allocate((int) afc.size());
        Attachment a = new Attachment();
        a.path = path1;
        a.buffer=buffer;
        a.channel = afc;

        // 开启异步读。
        afc.read(buffer, 0, a, handler);



        // 它先打印，才是对的。
        System.out.println("3、主线程，它又不能一直等待在这里。主线程可以干其它事件");
    }

}
