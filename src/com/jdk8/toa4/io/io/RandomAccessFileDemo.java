package com.jdk8.toa4.io.io;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by kobe on 2019/6/17.3:14
 *
 * @author kobe
 * <br/>
 * Description:
 * 能够同时读和写 的流。
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\f1.txt";

        init(p);
        for (int i = 0; i < 3; i++) {
            read(p);
        }
    }

    private static void read(String fileName) {
        try (
                RandomAccessFile f = new RandomAccessFile(fileName, "rw")
        ) {
             int num = f.readInt();
             String namw = f.readUTF();
            System.out.println(num + "\t" + namw);
            // 读取完了之后在写，把 num++ ，在写入到文件当中去。

            // 得到当前文件的位置。文件指针
            long p = f.getFilePointer();
            // 把这个读取的指针，指向到最开头的位置。
            f.seek(0);
            // num++
            num = f.readInt();
            num++;
            f.seek(0);
            // 在写。
            f.writeInt(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void init(String fileName) {
        try (
                RandomAccessFile f = new RandomAccessFile(fileName, "rw")
        ) {
            f.writeInt(200);
            f.writeUTF("kboe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
