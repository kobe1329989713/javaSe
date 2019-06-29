package com.jdk8.toa3.lambda;

import java.io.IOException;

/**
 * Created by kobe on 2019/6/28.6:13
 * action EditorChooseLookupItemCompleteStatement
 *
 * @author kobe
 * <br/>
 * Description:
 * 目标类型。
 */
@FunctionalInterface
interface Interface1 {
    void m(int num1, int num2);
}

@FunctionalInterface
interface Interface2 {
    void m(int num1, int num2);
    //void m(String num1, int num2);
}

@FunctionalInterface
interface Interface3 {
    String m(String num1, int num2);
}

@FunctionalInterface
interface Interface4 {
    String m(String num1, int num2) throws IOException;
}

public class TargetType {

    static void test1(Interface1 i) { }

    //static void test2(Interface2 i) { }
    static void test1(Interface2 i) { }

    // 返回一个lambda 表达式。
    // 返回值也可以是一个 lambda 表达式。
    static Interface1 test3() {
        return (n, n1) -> System.out.println(n + n1);
    }

    public static void main(String[] args) {
        // 方法形参。
        // 如果是方法重载，那么哪两个函数式接口的参数要不一样才行。
        //test1((int n, int n1) -> System.out.println(n + n1));
        //test1((String n, int n1) -> System.out.println(n + n1));
        //test2((n, n1) -> System.out.println(n + n1));

        // 参数一样时，可以使用变量的形式，如下；
        Interface1 i1 = (n, n1) -> System.out.println(n + n1);
        Interface2 i2 = (n, n1) -> System.out.println(n + n1);
        test1(i1);
        test1(i2);

        // 还可以使用强转。


        //Interface1 i1 = (num1, num2) -> System.out.println(num1 + num2);
        //Interface2 i2 = (num1, num2) -> System.out.println(num1 + num2);
        //Interface3 i3 = (num1, num2) -> num1 + num2;
        //Interface4 i4 = (num1, num2) -> {
        //    try {
        //        System.in.read();
        //    } catch (IOException e) {
        //        e.printStackTrace();
        //    }
        //    return num1 + num2;
        //};
        Interface4 i4 = (n1, n2) -> {
            System.in.read();
            return n1 + n2;
        };
    }
}
