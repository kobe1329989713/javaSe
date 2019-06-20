package com.jdk8.toa3.reflect.d;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by kobe on 2019/6/20.1:05
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class DogTest {
    public static void main(String[] args) throws Exception {
        // 通过反射创建 Dog 对象。
        //Class<Dog> c = Dog.class;
        Class<?> c = Class.forName("com.jdk8.toa3.reflect.d.Dog");
        try {
            // 如果没有无参构造方法，调用它会报错。
            // 私有构造也会报错。非法访问异常。
            Dog dog = (Dog) c.newInstance();

            // 调用任意构造。
            Constructor<?> constructor = c.getConstructor(String.class);
            Dog d = (Dog) constructor.newInstance("kobe");
            // 就可以打点调用其属性和方法。

            // 通行反射得到方法，
            Method m1 = c.getDeclaredMethod("m1");
            // 通过反射调用方法，注：这个 d，还有它的调用方式。
            // 参数一那个实例，参数二这个方法有什么参数。
            // 这个m1() 它没有返回值。
            System.out.println(m1.invoke(d));

            // 调用m2() 方法，它有参数，有返回值。
            Method m2 = c.getDeclaredMethod("m2", String.class);
            //Object test = m2.invoke(d, "test");
            System.out.println(m2.invoke(d, "test"));

            // 通过反射实现，对象调用属性。
            Field f = c.getDeclaredField("name");
            // 如果要访问私有成员或者方法。要设置如下。
            f.setAccessible(true);
            f.set(d,"mar222");
            System.out.println(f.get(d));


        } catch (InstantiationException | IllegalAccessException e) {
            // 没有构造方法 会报第一个。
            // 构造方法是私有的，会报第二个错。
            e.printStackTrace();
        }
    }
}
