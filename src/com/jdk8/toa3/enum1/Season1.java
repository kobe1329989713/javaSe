package com.jdk8.toa3.enum1;

/**
 * Created by kobe on 2019/6/20.3:47
 *
 * @author kobe
 * <br/>
 * Description:
 */
public enum Season1 {
    /**
     * 春夏秋冬
     */
    S("s"),  // 它们相当于在给name 赋值
    S1("s1"), // 注：每个枚举值，它的name 变量是不一样的。
    A("a"),
    W("w");

    // 枚举当中申明变量。
    String name;

    // 还可以搞构造方法。
    // 你写构造方法，也是不能new 的
    Season1(String name) {
        this.name = name;
        System.out.println("枚举的有参构造方法。");
    }

    Season1() {
        // 每用一次这个枚举，构造就会调用一次。
        System.out.println("枚举的构造方法。");
    }

    // 枚举当中的方法。
    public String getName() {
        return name;
    }

}
