package com.jdk8.toa4.io.io;

import java.io.FileInputStream;

/**
 * Created by kobe on 2019/6/17.0:39
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class FileInputStreamDemo1 {
    public static void main(String[] args) {
        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\f1.txt";
        // 最终版本。
        try (FileInputStream fis = new FileInputStream(p)) {
            byte byteDate;
            while ((byteDate = (byte) fis.read()) != -1) {
                System.out.print((char) byteDate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



        // 它里面是字节。
        //FileInputStream fis = new FileInputStream(p);
        //int data = fis.read();
        // 不等于 -1 ，说明这个输入流 里面还有数据。就要继续的循环，所以使用 while 循环。
        //byte byteDate;
        //while (data != -1) {
        //    byteDate = (byte) data;
        // 在把字节 转换成字符，你就可以在控制台上面看到了。
        //System.out.print((char)byteDate);
        // 继续读取下一个字节。
        //data = fis.read();
        //}
        //fis.close();


        // 自动关闭的 写法。
        //try (FileInputStream fis = new FileInputStream(p)) {
            //int data = fis.read();
            //byte byteDate;
            //while (data != -1) {
            //    byteDate = (byte) data;
            //    System.out.print((char) byteDate);
            //    data = fis.read();
            //}

            // 上面那个循环也是可以在简化下的。
        //    while ((byteDate = (byte) fis.read()) != -1) {
        //        System.out.print((char) byteDate);
        //    }
        //
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}






    }
}
