package com.jdk8.toa3.enum1;

/**
 * Created by kobe on 2019/6/20.3:47
 *
 * @author kobe
 * <br/>
 * Description:
 */
public enum  Season {
    /**
     * 春夏秋冬
     */
    S,S1,A,W;

    // 枚举当中申明变量。
    String name;

    // 还可以搞构造方法。
    // 你写构造方法，也是不能new 的
    Season(String name) {
        this.name = name;
        System.out.println("枚举的有参构造方法。");
    }

    Season() {
        // 每用一次这个枚举，构造就会调用一次。
        System.out.println("枚举的构造方法。");
    }

    // 枚举当中的方法。
    public String getName() {
        return name;
    }

}
