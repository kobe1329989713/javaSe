package com.jdk8.toa3.generic;

/**
 * Created by kobe on 2019/6/19.20:07
 *
 * @author kobe
 * <br/>
 * Description:
 * 泛型接口。
 */
public interface GenericInterface<T, E> {
    T test();

    E test1(E e);
}

class Impl1 implements GenericInterface<String, Integer> {
   // 注：T E 都是匹配的，你在返回类型或者是参数类型那里写  E T 那么它在使用的
   // 时候就是 你传的那些类型。

    @Override
    public String test() {
        System.out.println("test");
        return "test";
    }

    @Override
    public Integer test1(Integer integer) {
        System.out.println("test1");
        return 33;
    }

    public static void main(String[] args) {
        GenericInterface<String, Integer> s1 = new Impl1();
        String test = s1.test();
        Integer integer = s1.test1(33);
        System.out.println(test + "\t" + integer);
    }

}
