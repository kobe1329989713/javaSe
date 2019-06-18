package com.jdk8.toa4.io.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by kobe on 2019/6/17.7:37
 *
 * @author kobe
 * <br/>
 * Description:
 * 用通道做文件 copy
 */
public class FileCopyDemo {

    public static void main(String[] args) {
        final long now = System.currentTimeMillis();

        String source = "D:\\kobe\\desc\\VMwareShared\\cn_windows_10_consumer_edition_version_1809_updated_sept_2018_x64_dvd_f7b9c8a9.iso";
        String target = "D:\\kobe\\desc\\c8a9.iso";


        try(
                final FileChannel src = new FileInputStream(source).getChannel();
                final FileChannel des = new FileOutputStream(target).getChannel()
        ){
            // 0,全部拷贝。文件大小。拷贝到那里去。
            //src.transferTo(0, src.size(), des);
            // 源文件、0，文件大小。
            des.transferFrom(src, 0, src.size());
            // 它们都是 从文件 0 的位置到 文件的总大小的位置。就是全部拷贝。


        } catch (IOException e) {
            e.printStackTrace();
        }


        System.err.println(System.currentTimeMillis() - now);
    }

}
