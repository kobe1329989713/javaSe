package com.jdk8.io.io;

import java.io.*;

/**
 * Created by kobe on 2019/6/17.2:03
 *
 * @author kobe
 * <br/>
 * Description:
 * 将基本数据类型，写入到文件去。
 */
public class DateOutputStream {
    public static void main(String[] args){
        // 什么后缀名都是可以的，只要数据在这个文件里面即可。
        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\test\\xx.kobe";
        try (
                //DataOutputStream dos = new DataOutputStream(new FileOutputStream(p));
                DataInputStream dis = new DataInputStream(new FileInputStream(p))
        ) {
            // 将基本数据类型，写入到文件去。
            //dos.writeInt(100);
            //dos.writeDouble(12.34D);
            //dos.writeUTF("写入一个字符串");


            // 在将数据读取出来。
            System.out.println(dis.readInt());
            System.out.println(dis.readDouble());
            System.out.println(dis.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
