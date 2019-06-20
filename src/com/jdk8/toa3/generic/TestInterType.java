package com.jdk8.toa3.generic;

/**
 * Created by kobe on 2019/6/19.22:48
 *
 * @author kobe
 * <br/>
 * Description:
 */
class Class1<T>{

}
class User<T> {
    public User(Class1<T> c) { }
    public User() { }
    public User(T t) { }

}
public class TestInterType {
    public static void main(String[] args) {

        // 它就能推断到Integer ,用的的是带有 Class1 那个构造。
        User<Integer> user3 = new User<>(new Class1<>());
        User<Integer> user4 = new User<>(new Class1<Integer>());
        // 它就报错了。它就没有办法 给前面Integer赋值了，所以报错球。
        //User<Integer> user5 = new User<>(new Class1<String>());


        // 它是通过空构造(左边) 来推断的。
        User<String> user1 = new User<>();
        // 这个User2 就会推断为 String 因为它是通过 构造方法来推断的。
        User<String> user2 = new User<>("Hello");
        // 你要把 String 改成 Integer
        //User<String> user3 = new User<>(new Integer(100));
        // 通过方法调用来推断，
        test(new User<String>());
        // 通过形式参数来推断类型。
        test(new User<>());
    }

    // 通过形式参数来推断类型。
    static void test(User<String> user) {

    }

}
