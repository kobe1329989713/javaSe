package com.jdk8.io.io;

import java.io.*;

/**
 * Created by kobe on 2019/6/17.2:55
 *
 * @author kobe
 * <br/>
 * Description:
 *  txt xml 都是可以使用字符流，来操作。
 */
public class ReaderDemo {
    public static void main(String[] args) {
        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\f1.txt";
        try (
                //FileReader fr = new FileReader(p);
                //BufferedReader br = new BufferedReader(fr)
                // InputStreamReader 它是字节流与字符流的一个转换。
                // InputStreamReader 把一个字节输入流 转换成 BufferedReder 方法字符的操作。
                //BufferedReader br = new BufferedReader(new InputStreamReader())

                // 写。
                BufferedWriter bw = new BufferedWriter(new FileWriter(p))
        ) {
            // 直接就把数字一行行的读取出来了。
            //String s = "";
            //while ((s = br.readLine()) != null) {
            //    System.out.println(s);
            //}



            // 字符流 写入数据
            // 它们都是写数据
            //bw.write("222");
            // 它可以链式调用。
            //bw.append("")
            bw.append("Hello");
            // 换行。
            bw.newLine();
            bw.append("kobe");
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
