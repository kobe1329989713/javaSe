package com.jdk8.toa4.io.io;

import java.io.File;

/**
 * Created by kobe on 2019/6/16.23:55
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class FileDemo {
    public static void main(String[] args) throws Exception {
        // 获取当前用户的工作目录。
        System.out.println(System.getProperty("user.dir"));
        //String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\f1.txt";
        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\test\\a01\\a02\\a030";
        // 它是到用户当前的工作目录，去找这个 f1.txt 文件。
        //String p = "f1.txt";
        File f1 = new File(p);
        System.out.println("判断这个文件是否存在：" + f1.exists());

        // 不存在就创建它。
        //System.out.println(f1.createNewFile());
        // 创建目录。
        //f1.mkdir();
        // 子目录也创建出来。
        //f1.mkdirs();
        // 删除
        //System.out.println(f1.delete());
        // 重命名
        //f1.renameTo(new File("xx"));


        // 查看临时目录。
        System.out.println(System.getProperty("java.io.tmpdir"));
        // 创建临时文件。
        //File.createTempFile("aaa", "tomp");
    }
}
