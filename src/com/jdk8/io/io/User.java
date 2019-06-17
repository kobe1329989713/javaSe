package com.jdk8.io.io;

import java.io.Serializable;

/**
 * Created by kobe on 2019/6/17.2:18
 *
 * @author kobe
 * <br/>
 * Description:
 * java 序列化
 */
public class User implements Serializable {
    private static final long serialVersionUID = 7344028790513757375L;
    private int age;
    private String name;

    // transient 被它修饰的将不被序列化，它也可以控制那些可被序列化那些不可以，它也叫瞬时
    private transient String name02;

    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
