package com.jdk8.toa3.reflect;

import java.lang.reflect.Field;

/**
 * Created by kobe on 2019/6/20.0:06
 *
 * @author kobe
 * <br/>
 * Description:
 */
interface Interface1{
    int NUM = 10;
}
class Class1{
    int num1;
    public String name;
}
class MyClass extends Class1 implements Interface1{
    int num2;
    public int num3;
    private int num4;
}
public class FieldInfo {
    public static void main(String[] args) throws NoSuchFieldException {
        Class<MyClass> c = MyClass.class;
        // 得到所有被public修饰的属性，包括继承而来的属性。
        Field[] fields1 = c.getFields();
        for (Field f : fields1) {
            System.out.println(f.getName());
        }
        // 得到申明的属性。
        // getDeclaredFields() 只会得到这个类里面自己申明的属性。
        Field[] fields = c.getDeclaredFields();
        for (Field f : fields) {
            System.out.println(f.getName());
        }
        System.out.println("=======================");
        //Field num3 = c.getField("num3");
        // 只得到自己类中的。
        Field num3 = c.getDeclaredField("num3");
        System.out.println(num3.getName());
        // 这个属性的 类型、访问修饰符、
        // 肯定就在 Field 的这个类里面了，因为它是一个对象，里面东东多多。

    }
}
