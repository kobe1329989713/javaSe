package com.jdk8.toa4.io.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by kobe on 2019/6/17.7:10
 *
 * @author kobe
 * <br/>
 * Description:
 * 内存映射文件，是java中操作文件最快的方式。
 */
public class MapBufferDemo {
    public static void main(String[] args) {
        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\nio\\f2.txt";
        try(
                final FileInputStream fis = new FileInputStream(p);
                final FileChannel c = fis.getChannel()
        ){
            final MappedByteBuffer mbb =
                    // 读取文件，从多少到多少。如果是比文件小说明，文件部分映射，
                    // 和文件一样大小，说明全部映射。c.size() 它就和文件一样大小。
                    // Integer.MAX_VALUE
                    c.map(FileChannel.MapMode.READ_ONLY, 0, c.size());

            // 开始读文件。
            while (mbb.hasRemaining()) {
                System.out.print((char)mbb.get());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
