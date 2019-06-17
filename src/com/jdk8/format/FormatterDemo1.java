package com.jdk8.format;

import java.util.Formatter;

/**
 * Created by kobe on 2019/6/16.4:17
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class FormatterDemo1 {
    public static void main(String[] args) {
        Formatter f1 = new Formatter();
        // 按照前面的格式，输出。
        System.out.println(f1.format("%s,%s","abc","def"));
    }
}
