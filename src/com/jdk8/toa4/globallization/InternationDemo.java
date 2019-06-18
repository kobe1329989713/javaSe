package com.jdk8.toa4.globallization;

import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by kobe on 2019/6/15.22:09
 *
 * @author kobe
 * <br/>
 * Description:
 * 国际化。
 *
 */
public class InternationDemo {

    public static void main(String[] args) throws UnsupportedEncodingException {


        // 使用 xx.properties 来做国际化。

        // 模拟语言环境
        Locale english = new Locale("en", "US");
        Locale china = new Locale("zh", "CN");


        // msg 语言包(资源包)，加  什么环境，
        // 通过 key 去获取资源包里面的 value，它就是不同国家的语言了。
        ResourceBundle rb = ResourceBundle.getBundle("msg",english);
        // 这个就是将来在 页面展示的数据。
        String name = rb.getString("name05");
        System.out.println(name);
//注：中文的需要转码才行，看有道笔记。


        // 中文获取出乱码的问题。
        //ResourceBundle bundle = ResourceBundle.getBundle("msg");
        //String valueCN = new String(bundle.getString("name").getBytes("ISO-8859-1"), "UTF8");
        //System.out.println(valueCN);




        // 使用 类 的形式，来做国际化。
        // Error_xx_XX 这种类只能放在 src 根目录下。
        // 不是就要指定路径
        //Locale locale = new Locale("zh", "CN");
        //ResourceBundle rb = ResourceBundle.getBundle("com.jdk8.toa4.globallization.Error", locale);
        //String name = rb.getString("password");
        //System.out.println(name);
    }

}
