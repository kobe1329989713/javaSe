package com.jdk8.toa4.io.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Created by kobe on 2019/6/17.3:46
 *
 * @author kobe
 * <br/>
 * Description:
 * 把你输出的东东，重定向到另外一个地方去，如重定向到一个文件里面去。日志就是这么来的。
 */
public class RddirectDemo {
    public static void main(String[] args) {
        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\f1.txt";
        final File f = new File(p);
        try (
                PrintStream ps = new PrintStream(f)
        ) {
            // 就把标准的输出，重定向到了，p 哪个文件里。
            System.setOut(ps);
            // 它们都是可以重定向的。
            //System.setErr();
            //System.setIn();

            for (int i = 0; i < 3; i++) {
                System.out.println("Hello__" + i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
