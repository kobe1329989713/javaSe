package com.jdk8.toa3.generic;

/**
 * Created by kobe on 2019/6/19.21:46
 *
 * @author kobe
 * <br/>
 * Description:
 */
class Parent<T>{
    public void test(T t) { }
}
// 注：这里 类型擦除后 是Object 所以这里应该是错误的。
// 但是在泛型方法重写这里，它是 对的，因为编译器，会帮你把这个方法给 转一下。看转一下
class Son extends Parent<String>{
    // 重写父类里面的方法。
    @Override
    public void test(String s) {
        System.out.println(s.toString());
        super.test(s);
    }
    /**
     转一下
     public void test(Object o){
        this.test((String)o);
     }
     所以泛型方法重写，这里是对的。
     注：这一步是编译器帮你做的。这个方法叫：桥方法。
     */
}


public class GenericMethodOverrideDemo {
    public static void main(String[] args) {

    }
}
