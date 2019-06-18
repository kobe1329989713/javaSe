package com.jdk8.toa4.io.nio2;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.PosixFileAttributeView;

/**
 * Created by kobe on 2019/6/17.19:08
 *
 * @author kobe
 * <br/>
 * Description:
 * 文件属性。
 */
public class FileAttrDemo {
    public static void main(String[] args) throws IOException {
        Path p = Paths.get("C:");
        FileStore s = Files.getFileStore(p);
        // 是否支持某种文件视图。
        // 寻六个文件视图都是可以这样传进去，以验证它是否支持这个文件视图。
        System.out.println(s.supportsFileAttributeView(BasicFileAttributeView.class));
        // 它是一个Unix 系统的一个文件视图。
        System.out.println(s.supportsFileAttributeView(PosixFileAttributeView.class));
    }
}
