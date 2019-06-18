package com.jdk8.toa4.io.nio;

import java.io.*;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by kobe on 2019/6/17.6:36
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class ChannelDemo1 {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("")) {
            // 把一个输入流（XxxInputStream) 转换为 通道（Channel)
            ReadableByteChannel c1 = Channels.newChannel(fis);
            // 在把通道 转换为流。
            InputStream is = Channels.newInputStream(c1);

            // 它是一个 只读的 通道。
            FileChannel c2 = fis.getChannel();
            RandomAccessFile f = new RandomAccessFile("", "r");
            // 这个 f 是一个只读的，你通过这个 f 得到的通道也是只读的。
            // f 是什么 得到的通道也是什么。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
