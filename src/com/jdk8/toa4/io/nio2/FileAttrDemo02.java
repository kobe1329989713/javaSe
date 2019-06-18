package com.jdk8.toa4.io.nio2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

/**
 * Created by kobe on 2019/6/17.19:14
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class FileAttrDemo02 {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("D:\\kobe\\xx\\f2.txt");
        // 得到文件的一些属性，
        //System.out.println(Files.getAttribute(p, "basic:size"));
        //System.out.println(Files.getAttribute(p, "size"));
        //System.out.println(Files.getAttribute(p, "dos:readonly"));

        // 设置文件属性。它有些属性是可以改，有些是不能修改的。
        // size 是不能修改的， 最后修改时间 是可以修改的。
        // 这样就把 p 这个文件的最后修改时间，修改成了当前的时间了。
        // 这些属性是在 API 文档上面。
        //Files.setAttribute(p, "lastModifiedTime", FileTime.from(Instant.now()));


        // 得到多个属性。
        BasicFileAttributes fa = Files.readAttributes(p, BasicFileAttributes.class);
        // 这个 fa 里面就有很多属性了。
        //System.out.println(fa.size());
        //System.out.println(fa.lastAccessTime());

        Map<String, Object> fa1 = Files.readAttributes(p, "size,lastModifiedTime");
        fa1.forEach((k,v)->{
            System.out.println(k + "\t" + v);
        });


        BasicFileAttributeView bfv = Files.getFileAttributeView(p, BasicFileAttributeView.class);
        BasicFileAttributes bf = bfv.readAttributes();
        // bf 里面就有很多属性，等你获取。
        System.out.println(bf.size());
    }
}
