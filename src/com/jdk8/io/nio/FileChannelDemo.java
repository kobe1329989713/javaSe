package com.jdk8.io.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by kobe on 2019/6/17.6:45
 *
 * @author kobe
 * <br/>
 * Description:
 * 通过，通道（channel) 来读写文件。
 */
public class FileChannelDemo {
    public static void main(String[] args) {
        // 计算程序运行耗费的时间。
        // System.currentTimeMillis(); 得到的是 1970/01/01 到现在时间的一个 毫秒数。
        final long now = System.currentTimeMillis();

        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\nio\\f2.txt";

        // 读文件。
        //read(p);
        // 写文件。
        writefile(p);

        System.out.println("===");
        // 程序耗费的时间。
        System.err.println(System.currentTimeMillis() - now);
    }

    private static void writefile(String p) {
        try(
                final FileOutputStream fos = new FileOutputStream(p);
                final FileChannel c = fos.getChannel()
        ){
            String test = "abcdefkasdfhasdf";
            final ByteBuffer buffer = ByteBuffer.wrap(test.getBytes());
            c.write(buffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 使用 通道 来读取文件。
     * @param path
     */
    private static void read(String path) {
        final ByteBuffer buffer = ByteBuffer.allocate(1024);
        try(
                FileInputStream fis = new FileInputStream(path);
                final FileChannel c = fis.getChannel()
        ){
            final ByteBuffer buffer1 = ByteBuffer.allocate(1024);
            // 通道从 buffer 里面读取数据。
            while (c.read(buffer) > 0) {
                // buffer 每次读取数据的先
                buffer.flip();
                while (buffer.hasRemaining()) {
                    System.out.print((char) buffer.get());
                }
                // buffer 每次读完之后 也要如下
                // 这样Buffer 就回到了初始状态了。为下次读做做准备
                buffer.clear();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
