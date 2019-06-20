package com.jdk8.toa3.reflect;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.lang.reflect.*;

/**
 * Created by kobe on 2019/6/20.2:17
 *
 * @author kobe
 * <br/>
 * Description:
 */
class Bird<T> {
    void m(T t) {
        System.out.println(t);
    }
}

public class TestReflection {
    // 注：它是这个类的一个成员变量而已。
    //Bird<String> b = new Bird<>();
    //Bird<Integer> b = new Bird<>();
    Bird<? extends Integer> b = new Bird<>();


    // 一个泛型方法。
    <V> void m() { }

    // 一个泛型数组。
    Bird<String>[] bs = new Bird[10];


    public static void main(String[] args) throws Exception {
        Class<TestReflection> c = TestReflection.class;
        Field f1 = c.getDeclaredField("b");
        // 它是一个原生类型。
        System.out.println(f1.getType().getName());
        // 得到这个 b 的泛型类型。
        // 如果是属于那种参数化的类型，它有道。
        if (f1.getGenericType() instanceof ParameterizedType) {
            System.out.println(((ParameterizedType) f1.getGenericType()).getActualTypeArguments()[0].getTypeName());

            // 看它是不是通配符类型的
            if (((ParameterizedType) f1.getGenericType()).getActualTypeArguments()[0] instanceof WildcardType) {
                // 如果是这种类型，就把它强转成通配符类型。
                WildcardType type = (WildcardType) ((ParameterizedType) f1.getGenericType()).getActualTypeArguments()[0];
                // 就能得到这个通配符的一些信息，如：它的上边界与下边界。
                System.out.println(type.getUpperBounds()[0].getTypeName());
            }
        }


        System.out.println("---------------------------");
        // 得到泛型方法 的类型。
        Method m = c.getDeclaredMethod("m");
        TypeVariable<Method> t = m.getTypeParameters()[0];
        System.out.println(t.getName());

        System.out.println("---得到泛型数组上的，属性------------------------");
        Field f2 = c.getDeclaredField("bs");
        // 判断这个f2 它是不是一个泛型数组。
        if (f2.getGenericType() instanceof GenericArrayType) {
            String typeName = ((GenericArrayType) f2.getGenericType()).getGenericComponentType().getTypeName();
            System.out.println(typeName);
        }

        System.out.println("----使用Bird里的泛型方法。---");
        Bird<String> b1 = new Bird<>();
        b1.m("abc");
        //b1.m(122);

        // 反射就能绕过泛型。
        Class<? extends Bird> c2 = b1.getClass();
        Method m2 = c2.getDeclaredMethod("m", Object.class);
        m2.invoke(b1,"cde");
        m2.invoke(b1,122);
    }
}
