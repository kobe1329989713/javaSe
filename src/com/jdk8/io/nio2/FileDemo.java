package com.jdk8.io.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;

/**
 * Created by kobe on 2019/6/17.17:49
 *
 * @author kobe
 * <br/>
 * Description:
 * // 文件拷贝。
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {
        final Path src = Paths.get("D:\\kobe\\xx\\xX01\\hadoop-3.1.2.tar.gz");
        // 目标。
        final Path des = Paths.get("D:\\kobe\\xx\\xx001.tar.gz");
        // StandardCopyOption. 它是一个枚举，参数如下。它是一个枚举，实现了CopyOption 接口。枚举也是可以实现接口的。
        // ATOMIC_MOVE 拷贝过去后，在把原文件给删除掉。
        // COPY_ATTRIBUTES   把属性也拷贝过去
        // REPLACE_EXISTING，假如拷贝过去的文件存在就替换。
        // 注：第三个参数是一个动态参数哦。
        //final Path copy = Files.copy(src, des, StandardCopyOption.REPLACE_EXISTING);


        //Files  这个类里面 还能判断和获取 很多与文件相关的方法。
        // 最后修改时间。
        //final FileTime t = Files.getLastModifiedTime(src);
        //System.out.println(t);
        //System.out.println(t.toMillis());


        // 它能判断你是什么文件，如：文本 xml  压缩 图片 视频  等，是什么文件。
        System.out.println(Files.probeContentType(src));
        //
        final Path p2 = Paths.get("D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\nio\\f2.txt");
        // 用它操作文件巨方便。
        // 一行行读取数据。
        //Files.lines(p2).forEach(System.out::println);


        // 读取文件所有内容。字节。
        //final String s = new String(Files.readAllBytes(p2));
        //System.out.println(s);


        // 一句代码，读取文件。
        //Files.readAllLines(p2).forEach(System.out::println);


        // 写内容到文件。
        // 这样写就把 原先的文件给覆盖了。
        //Files.write(p2,"Hello02啊㗊㗊㗊㗊㗊".getBytes());
        // StandardOpenOption 这个枚举类，有很多。控制 写文件的内容，
        // 如、APPEND 就不会替换掉之前的，它拼接。 它不换行。
        // 还有很多控制？？？
        Files.write(p2,"Hello02啊㗊㗊㗊㗊㗊".getBytes(), StandardOpenOption.APPEND);
    }
}
