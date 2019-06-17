package com.jdk8.io.nio2;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by kobe on 2019/6/17.7:53
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class FileSystemDemo {
    public static void main(String[] args) throws IOException {
        final FileSystem fs = FileSystems.getDefault();
        System.out.println("它是不是只读的：" + fs.isReadOnly());
        System.out.println("它的分隔符是：" + fs.getSeparator());
        // 文件的存储。
        final Iterable<FileStore> fss = fs.getFileStores();
        for (FileStore s : fss) {
            System.out.println("文件系统里面的文件存储：" + s);
            System.out.printf("%s,%s,%s,%s,%s \n",
                    s.name(),
                    s.getTotalSpace(), // 总的空间
                    s.getUnallocatedSpace(), // 未分派的空间
                    s.getUsableSpace(), // 可用的空间
                    s.type()  // 文件系统的格式。
            );
        }
        // 得到根目录。
        final Iterable<Path> rootDirectories = fs.getRootDirectories();
        for (Path p : rootDirectories) {
            System.out.println(p);
        }
    }
}
