package com.jdk8.properties;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

/**
 * Created by kobe on 2019/6/15.23:45
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class PropertiesDemo {

    public static void main(String[] args) throws Exception {
        Properties p = new Properties();
        // 加载。
        p.load(new FileInputStream("resources/config.properties"));
        // 可以用map 的遍历方式，来遍历它。
        //p.forEach((n, v) -> System.out.println(n + "\t" + v));

        System.out.println(p.getProperty("name"));
        System.out.println(p.get("name"));

        // 修改值。
        p.setProperty("name", "kboe222");
        p.store(new FileOutputStream("resources/config.properties"),"");
        System.out.println(p.get("name"));

        // 增加。
        p.setProperty("newValue", "newValue");
        p.store(new FileOutputStream("resources/config.properties"),"");



        // 得到系统的一些信息。
        Properties sp= System.getProperties();
        sp.forEach((n, v) -> System.out.println(n + "\t" + v));
    }

}
