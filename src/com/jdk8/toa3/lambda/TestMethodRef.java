package com.jdk8.toa3.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by kobe on 2019/6/28.9:54
 *
 * @author kobe
 * <br/>
 * Description:
 * 方法引用。
 */
@FunctionalInterface
interface ToInt<T> {
    int convert(T t);
}
// 非泛型函数式接口。
@FunctionalInterface
interface Interfaces3{
    <T> T m(T t);
}
class MyClass3{
    static <T> T n(T t) {
        return t;
    }
}

public class TestMethodRef {
    public static void main(String[] args) {
        ToInt<String> t1 = s -> s.length();
        System.out.println(t1.convert("就可以获取任意字符串的长度了"));
        System.out.println(t1.convert("Tom"));

        // 用方法引用改进。parseInt()把Integer转换成String ,注：只能是数字的字符串
        ToInt<String> t2 = Integer::parseInt;
        System.out.println(t2.convert("111"));
        System.out.println(t2.convert("22222"));

        Supplier<Integer> s1 = ""::length;
        Supplier<Integer> s2 = "Kobe"::length;
        System.out.println(s2.get());

        Consumer<String> s3 = System.out::print;

        // 类名点方法。
        Function<String, Integer> f1 = String::length;
        Integer kobe = f1.apply("Rose and Kobe");
        System.out.println("kobe: " + kobe);


        //
        Son son = new Son();
        son.m();

        // 方法引用，之 调用 构造方法。
        Supplier<Son> son1 = Son::new;
        Son son2 = son1.get();

        // 构造赋值。
        // Function 需要一个String类型的参数，返回的是一个Son类型的。
        Function<String, Son> fun1 = Son::new;
        Son son3 = fun1.apply("Function 需要一个String类型的参数，返回的是一个Son类型的。");
        System.out.println(son3.getName());

        // 方法引用的 数组。
        // 创建一个 长度为5 的 int[] 数组。
        Function<Integer, int[]> fun2 = int[]::new;
        int[] ints = fun2.apply(5);

        // 这个也是创建一个长度为5 的int数组。
        Function<Integer, int[]> fun3 = size -> new int[size];
        // apply

        // 也可以创建多维数组。


        Interfaces3 i3 = MyClass3::n;
        String m = i3.m("泛型方法");
        System.out.println(m);
    }
}

class Parent{
    private String name = "kobe";

    public String getName() {
        return name;
    }

}
class Son extends Parent{
    private String name = "kobe_Son";

    public Son() { }

    public Son(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    void m() {
        Supplier<String> s1 = this::getName;
        Supplier<String> s2 = Son.super::getName;
        System.out.println("son: " + s1.get() + "\t" + "parent: " + s2.get());
    }
}
