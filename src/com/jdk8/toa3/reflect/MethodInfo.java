package com.jdk8.toa3.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by kobe on 2019/6/20.0:28
 *
 * @author kobe
 * <br/>
 * Description:
 */
class Class3 extends Class2{
    @Override
    void m4() { }
}
abstract class Class2{
    public Class2() { }
    public Class2(int num) { }

    public void m1() { }
    public void m1(int num) { }
    private void m2() { }
    static void m3() { }
    abstract void m4();
}
public class MethodInfo {
    public static void main(String[] args) throws Exception {
        Class<Class2> c = Class2.class;

        // 把父类的方法也输出了，就是 Object
        // 只能得到 公有方法和继承而来的方法，无法得到私有方法。
        // 默认和受保护，它也是不能获取的。
        //Method[] m1 = c.getMethods();
        // 它会得到这个类所有的方法。不包括父类的。
        // 只要是这个类里面的方法，它都能获取，包括 抽象、静态 方法。
        Method[] m1 = c.getDeclaredMethods();
        for (Method m : m1) {
            System.out.println(m.getName());
        }

        // 通过方法名来获取方法。
        //Method m2 = c.getDeclaredMethod("m1");
        // 获取有参数的方法。
        Method m2 = c.getDeclaredMethod("m1",int.class);
        System.out.println(m2.getName());
        // 得到方法的 返回值类型、参数类型、泛型相关的、注解、异常相关的 等……看api


        // 获取public构造方法。父类的构造方法，它是得不到的。
        //Constructor<?>[] cs = c.getConstructors();
        // 得到本类当中所有的构造方法，
        Constructor<?>[] cs = c.getDeclaredConstructors();
        //Constructor<?>[] cs = Class3.class.getConstructors();
        //Constructor<?>[] cs = MethodInfo.class.getConstructors();
        for (Constructor<?> c1 : cs) {
            System.out.println(c1.getName());
        }
    }
}
