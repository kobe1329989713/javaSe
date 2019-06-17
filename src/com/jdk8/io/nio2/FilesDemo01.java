package com.jdk8.io.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by kobe on 2019/6/17.8:39
 *  https://edu.51cto.com//center/course/lesson/index?id=51584
 *  nio- 2-3
 *
 * @author kobe
 * <br/>
 * Description:
 */
@SuppressWarnings("/all")
public class FilesDemo01 {

    public static void main(String[] args) throws IOException {
        final Path p1 = Paths.get("D:\\kobe\\xx\\xX01\\docker\\f2.txt");
        // 如果这个文件已经存在，你在创建它就会报错。
        //final Path file = Files.createFile(p1);

        // 判断是否存在
        //if (!Files.exists(p1)) {
            // 创建。
            //Files.createFile(p1);
        //}


        // 不存在。
        if (Files.notExists(p1)) {

        }


        // 创建目录。
        final Path p2 = Paths.get("D:\\kobe\\xx\\xX01\\docker\\f2\\txt");
        // 它只能创建一级。
        //final Path directory = Files.createDirectory(p2);
        // 它能级联创建。
        //final Path directory = Files.createDirectories(p2);

        // 创建临时文件，可以指定，前缀、后缀、可变长度的。
        //final Path ttt = Files.createTempFile("ttt", ".tmp");
        // 在把路径返回来。
        //System.out.println(ttt.toRealPath());


        // 创建符号连接，相当于是创建 快捷方式
        // 创建的符号连接放在哪个位置、连接的目录地址、相关属性。
        //Files.createSymbolicLink(Paths.get("C:\\xx.txt"), Paths.get("D:\\xx01.txt"));
        // 当你打开 xx.txt ,实际上打开的是 xx01.txt 如果是 代表创建成功了。


        //  LinkOption.NOFOLLOW_LINKS ,它只看这个目录下文件是否存在。不会判断它是不是一个 连接文件
        // 或者是什么只要有这个文件就返回true
        System.out.println(Files.exists(p1, LinkOption.NOFOLLOW_LINKS));


        // delete  如果删除的文件或者是目录不存在，就会报出异常。
        // 所以你每次要删除之前，判断下它存在否。
        //Files.delete(p1);

        // 它就不会报错，只是返回true false
        Files.deleteIfExists(p1);

    }

}
