package com.jdk8.toa4.io.nio2;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by kobe on 2019/6/17.8:16
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class PathDemo {
    public static void main(String[] args) {
        String p = "D:\\kobe\\xx\\xX01\\docker\\xxx.xml";
        final Path p1 = FileSystems.getDefault().getPath(p);
        System.out.println(p1);
        // 组件，就是它路径的组成的部分，包含 根、目录、分隔符、最后的文件名。
        final int count = p1.getNameCount();
        System.out.println(count);
        // 是哪几个。循环打印出来看看。
        for (int i = 0; i < count; i++) {
            System.out.println(p1.getName(i));
        }
        // 得到根目录。
        System.out.println(p1.getRoot());
        // 得到父目录。
        System.out.println(p1.getParent());
        // 判断它是不是一个绝对路径。
        System.out.println(p1.isAbsolute());

        final Path p2 = Paths.get("D:\\kobe\\xx\\xX01\\xx\\xxx.xml");
        // normalize() 把带有点 .. 的路径，更能直观的输出
        System.out.println(p2.normalize());

        // 把两个路径拼接起来了。
        final Path p3 = Paths.get("f3\\xx01");
        System.out.println(p2.resolve(p3));



        // 看p4 这个路径，相对 p2 这个路径是多少。
        final Path p4 = Paths.get("D:\\f3\\xx01");
        System.out.println(p2.relativize(p4));
        System.out.println(p4.relativize(p2));


        // 路径截取样。
        System.out.println(p2.subpath(0,3));

        // 判断 是不是以什么开着、结尾、相等。
        System.out.println(p2.startsWith(p4));
        System.out.println(p2.endsWith(p4));
        System.out.println(p2.equals(p4));
    }
}
