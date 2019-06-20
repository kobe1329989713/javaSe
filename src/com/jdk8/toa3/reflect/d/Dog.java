package com.jdk8.toa3.reflect.d;

/**
 * Created by kobe on 2019/6/20.1:05
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class Dog {

    //public String name;
    private String name;

    public Dog(String name) {
        System.out.println("dog 有参构造。" + name);
    }

    public Dog() {
        System.out.println("dog 无参构造。");
    }

    public int m2(String s) {
        System.out.println("m2" + s);
        return 1;
    }

    public void m1() {
        System.out.println("m1");
    }

}
