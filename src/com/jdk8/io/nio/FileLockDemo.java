package com.jdk8.io.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by kobe on 2019/6/17.7:22
 *
 * @author kobe
 * <br/>
 * Description:
 * 锁定文件。
 */
public class FileLockDemo {
    public static void main(String[] args) {
        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\nio\\f2.txt";
        try(
                final RandomAccessFile r = new RandomAccessFile(p,"rw");
                // 通过流得到通道。
                final FileChannel c = r.getChannel()
        ){
            // 这个是排它锁，其它人 打都打不开。
            // 在读这个文件的时候，我把它锁住，使其它线程不能访问它，只能我操作这个文件。
            //final FileLock lock = c.lock();

            // 共享锁，其它人能打开，但不能编辑保存。
            // 参数1 2，文件的位置，从文件的什么位置到什么锁住，可以锁住文件的部分内容。true 就共享锁。
            final FileLock lock = c.lock(0, c.size(), true);


            // 这个五秒钟之内，只能我操作。其它写不了
            Thread.sleep(50000);
            // 五秒钟之内释放锁。
            lock.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
