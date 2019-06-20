package com.jdk8.toa3.enum1;

/**
 * Created by kobe on 2019/6/20.3:47
 *
 * @author kobe
 * <br/>
 * Description:
 */
public enum Season2 {
    // 在枚举当中，写方法。
    S("s"){
        public int get() {
            System.out.println("get()");
            return 1;
        }

        @Override
        public void m2() {
            // get() 只有它能调用。
            get();
            System.out.println("m2()");
        }
    },
    S1("s1"){
        @Override
        public void m2() { }
    },
    A("a"){
        @Override
        public void m2() { }
    },
    W("w"){
        @Override
        public void m2() { }
    };

    // 枚举当中还可以有抽象方法。
    public abstract void m2();


    // 枚举当中申明变量。
    String name;

    // 还可以搞构造方法。
    // 你写构造方法，也是不能new 的
    Season2(String name) {
        this.name = name;
        System.out.println("枚举的有参构造方法。");
    }

    Season2() {
        // 每用一次这个枚举，构造就会调用一次。
        System.out.println("枚举的构造方法。");
    }

    // 枚举当中的方法。
    public String getName() {
        return name;
    }

}
