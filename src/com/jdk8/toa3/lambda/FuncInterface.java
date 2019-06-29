package com.jdk8.toa3.lambda;

/**
 * Created by kobe on 2019/6/28.8:00
 *
 * @author kobe
 * <br/>
 * Description:
 */
// 函数式接口。
@FunctionalInterface
interface Fun {
    void m();
    //void n(); 它就是 XXX

    // 函数接口是 只有一个方法的接口，但是
    // 静态方法和默认都是不计算在内的。
    String toString();

    static void m1() { }
}

interface Fun1<T> {
    void m();
}

interface Fun2<T> {
    T m(T t);
}

interface Fun3 {
    <T> T m(T t);
}

// 标记接口。
interface MakeInterface{

}

class TestFunInterface{
    void test() {
        Fun1<String> f1 = () -> System.out.println("");
    }

    void test1() {
        Fun2<String> f2 = s -> s + "abc";
    }

    void test2() {
        // Fun3 函数式接口就不行。因为不是泛型接口，只是泛型方法是不行的。
        // 这种可以使用方法引用来调用。
        //Fun3 f3 = s -> s + "abc";
    }

    void test3() {
        // lambda 表达式，也不能赋值给一个标记接口。
        //MakeInterface mi = () -> System.out.println("");
        // 可以用& 符号来解决这个问题。就赋值给标记接口申明的变量了。
        MakeInterface mi = (MakeInterface & Fun2<String>) s -> s + "abc";
    }

}

public class FuncInterface {
    public static void main(String[] args) {

    }





}
