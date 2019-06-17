package com.jdk8.io.nio2;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by kobe on 2019/6/17.18:32
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class FileTreeDemo {
    public static void main(String[] args) throws IOException {
        //printName("D:\\kobe\\xx");

        // 包括这个 x02 也会被删除。
        deleteDir("D:\\kobe\\xx\\x02");
    }

    // 把一个文件夹下所有的东东遍历出来。包括子目录里面的。
    private static void printName(String path) throws IOException {
        Path p = Paths.get(path);
        System.out.println("是否存在：" + Files.exists(p));

        FileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                // 访问目录里的每个条目(文件/文件夹)继续，
                return FileVisitResult.CONTINUE;
            }

            // 在你访问每个文件或者是文件夹时 执行。
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println(file);
                return FileVisitResult.CONTINUE;
            }
        };

        Files.walkFileTree(p, visitor);
    }

    // 递归删除。
    public static void deleteDir(String path) throws IOException {
        Path p = Paths.get(path);
        SimpleFileVisitor<Path> visitor = new SimpleFileVisitor<Path>() {
            // 访问了所有的条目后，就把它删除。
            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }

            // 删除文件本身。
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }
        };

        Files.walkFileTree(p, visitor);
    }

}
