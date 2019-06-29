package com.jdk8.toa3.lambda;

import java.util.function.Consumer;

/**
 * Created by kobe on 2019/6/28.10:33
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class ScopeDemo {
    void me() {
        int num = 10;
    }

    //static int num = 20;

    public static void main(String[] args) {
        int num = 20;
        /**
         它有两个变量，num 和 n , num 是在外围，n 是在lambda表达式里面申明的。
         而 lambda表达式可以使用外围的申明的变量。
         */
        //num = 30;
        Consumer<Integer> c1 = n -> System.out.println(num + n);
        // lambda表达式用到的变量只能初始化一次。或者这个变量是被final修饰的。
        // 属于成员变量，就没有这个限制，因为它是属于某个对象的。
        //num = 30;
        c1.accept(20);

        // 它就报错了，因为你在lambda表达式里面申明一个num变量又在外围申明了一个num变量。
        //Consumer<Integer> c2 = num -> System.out.println(num + 12);
    }
}
