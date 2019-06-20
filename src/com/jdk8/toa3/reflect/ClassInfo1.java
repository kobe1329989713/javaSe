package com.jdk8.toa3.reflect;

import java.io.Serializable;
import java.lang.reflect.Modifier;

/**
 * Created by kobe on 2019/6/19.23:48
 *
 * @author kobe
 * <br/>
 * Description:
 */
class Person extends Thread implements Serializable {

}
public class ClassInfo1 {
    public static void main(String[] args) {
        Class<Person> c = Person.class;
        // 得到类名 全路径。
        System.out.println(c.getName());
        // 得到一个简单的名字。只有类名。
        System.out.println(c.getSimpleName());
        // 所在的包名。
        System.out.println(c.getPackage().getName());
        // 它是不是一个基本数据类型。
        System.out.println(c.isPrimitive());
        // 是不是接口。isXxx() 都是判断 如 是不是一个，抽象类、枚举、等……
        System.out.println(c.isInterface());
        System.out.println(int.class.isPrimitive());
        // 得到父类。
        Class<? super Person> sc = c.getSuperclass();
        System.out.println(sc.getName());
        // 实现接口信息。
        Class<?>[] si = c.getInterfaces();
        for (Class<?> s1 : si) {
            System.out.println(s1.getName());
        }
        // 得到访问修饰符
        int mod = c.getModifiers();
        System.out.println(Modifier.toString(mod));
        System.out.println();
        //int ii1 = Integer.class.getModifiers();
        int ii1 = Serializable.class.getModifiers();
        System.out.println(Modifier.toString(ii1));
        // 类的申明信息。
        System.out.println(c.toGenericString());
    }
}
