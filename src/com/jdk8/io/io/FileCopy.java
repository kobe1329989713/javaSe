package com.jdk8.io.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by kobe on 2019/6/17.1:02
 *
 * @author kobe
 * <br/>
 * Description:
 *  出现这种
 *  (拒绝访问。)  q错误，可能是你没有写文件名，
 *
 *  因为你copy文件，只给目标一个路径，它不知道以什么文件名字，存放在目标目录去，所以就报这个错误。
 */
public class FileCopy {
    public static void main(String[] args) {
        String source = "D:\\kobe\\xx\\xX01\\hadoop-3.1.2.tar.gz";
        String target = "D:\\kobe\\xx\\jar\\xxx.tar.gz";
        try (
                FileInputStream fis = new FileInputStream(source);
                FileOutputStream fos = new FileOutputStream(target);
        ) {
            // 每次读取的数据，就缓存在这个数组里面。然后在把它写入到输出流里。
            byte[] data = new byte[2048];
            // 当读取到最后一次时，长度可能不够 2048
            int lenght = 0;
            while ((lenght = fis.read(data, 0, data.length)) != -1) {
                fos.write(data,0,lenght);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 如果要做剪切，在你复制完成以后，直接把原始文件删除即可。

    // IO 其它的子类 也是这样操作的。

    /**
     File 类，只是对 文件或者文件夹的信息做读取，甚至可以设置，它没有办法对文件的内容做操作的。
     io 就是对文件的内容来做操作的。
     */
}
