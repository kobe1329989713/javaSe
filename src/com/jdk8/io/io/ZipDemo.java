package com.jdk8.io.io;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.*;

/**
 * Created by kobe on 2019/6/17.3:57
 *
 * @author kobe
 * <br/>
 * Description:
 * java 操作 zip 压缩文件。
 */
public class ZipDemo {
    public static void main(String[] args) {
        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\f1.txt";
        String p1 = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\f2.zip";

        // 压缩。
        //createZip(p,p1);
        // 解压
        String p2 = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io";
        //unzip(p1,p2);


        // 查看这个压缩文件里面有那些文件（条目）
        //list(p1);
        list02(p1);

    }

    /**
     * 压缩
     * @param p  压缩那些文件
     * @param p1  压缩到那个路径下。
     */
    private static void createZip(String p,String p1) {
        try (
                ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(p1));
                BufferedInputStream bis = new BufferedInputStream(new FileInputStream(p))
        ) {
            // 设置压缩的级别。
            zos.setLevel(Deflater.BEST_COMPRESSION);
            // 条目，就是你要压缩哪些文件。
            // 在压缩文件里，叫什么文件名
            ZipEntry ze1 = new ZipEntry("f2.txt");
            zos.putNextEntry(ze1);

            // 你要先把文件给读出来，然后在写在 压缩文件里。写在 f2.txt 文件里。
            final byte[] buffer = new byte[1024];
            int len = -1;
            // 写 或者是 读 一个 0 到 这么长的 数据，到那里。
            while ((len = bis.read(buffer, 0, buffer.length)) != -1) {
                zos.write(buffer, 0, len);
            }


            // 如果在来一个文件 又是这样 操作，可以提取为一个方法。

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *  在把它解压出来
     * @param zipFile 解压的 zip 文件。
     * @param upPath 解压到那个路径。
     */
    private static void unzip(String zipFile,String upPath) {
        try (
                ZipInputStream zis = new ZipInputStream(new FileInputStream(zipFile))
        ) {
            ZipEntry entry = null;
            // 循环解压文件里面，有几个文件。
            while ((entry = zis.getNextEntry()) != null) {
               String name = entry.getName();
                String path = upPath + File.separator + name;
                File file = new File(path);
                // 不存在，就创建。
                if (file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
                // 开始把数据写入解压路径中。
                final byte[] buffer = new byte[1024];
                int len = -1;
                while ((len = zis.read(buffer, 0, buffer.length)) != -1) {
                    bos.write(buffer, 0, len);
                }
                bos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 查看这个压缩文件里面有那些文件（条目）
    public static void list(String zipFile) {
        try (ZipFile f = new ZipFile(zipFile)) {
            final Enumeration<? extends ZipEntry> e = f.entries();
            while (e.hasMoreElements()) {
                final ZipEntry ze = e.nextElement();
                System.out.println(ze.getName());
                // 还有其它的信息。
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 查看这个压缩文件里面有那些文件（条目） 02
    public static void list02(String zipFile) {
        try (ZipFile f = new ZipFile(zipFile)) {
            f.stream().forEach(enrty-> System.out.println(enrty.getName()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
