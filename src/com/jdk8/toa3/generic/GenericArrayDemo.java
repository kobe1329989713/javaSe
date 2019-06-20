package com.jdk8.toa3.generic;

/**
 * Created by kobe on 2019/6/19.23:09
 *
 * @author kobe
 * <br/>
 * Description:
 */
class Student<T>{
    public Student() {
        //T[] ts = new T[10];
    }
}
public class GenericArrayDemo {
    public static void main(String[] args) {
        // 用泛型或者泛型类来创建数组都是错误的。
        //new Student<String>[10]()

        // 用通配符可以。
        Student<?>[] students = new Student<?>[10];
        students[0] = new Student<String>();
        students[1] = new Student<Integer>();
        students[2] = new Student<Boolean>();
        // 你把这个数组取出来时，它们都是Student类型的。
        // 有可能出现类型异常。
    }
}
