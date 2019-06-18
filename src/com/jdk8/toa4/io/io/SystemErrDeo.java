package com.jdk8.toa4.io.io;

import java.io.IOException;

/**
 * Created by kobe on 2019/6/17.3:38
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class SystemErrDeo {
    public static void main(String[] args) throws IOException {
        System.err.println("以后打印错误时，可以用它来");

        // System.in
        int num = -1;
        while ((num = System.in.read()) != '\n') {
            System.out.print((char)num);
        }
        // 你在控制台输入了，没有打回车之前，数据都是存储在一个缓存里面的。
        // 只有当你敲击了回车以后，while 开始从哪个缓冲里面取数据，并打印出来。

    }
}
