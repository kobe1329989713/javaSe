package com.jdk8.toa3.reflect;

/**
 * Created by kobe on 2019/6/19.23:22
 *
 * @author kobe
 * <br/>
 * Description:
 */
class User{
    static {
        System.out.println("静态代码块，user init....");
    }
}

public class ReflectionDemo {

    static void create2() {
        // 它不会执行静态代码块。
        Class<User> c = User.class;
    }

    static void create3() {
        // forName 它有重载方法，传个boolean 是否初始化。否不执行静态代码。
        // 类的加载器
        try {
            //Class<?> aClass = Class.forName("com.jdk8.toa3.reflect.User");
            Class<?> aClass = Class.forName(
                    "com.jdk8.toa3.reflect.User",
                    false,
                    ReflectionDemo.class.getClassLoader() // 得到类加载器。
            );
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void create1() {
        new User();
    }

    public static void main(String[] args) throws Exception {

        //create1();
        //create2();
        //create3();

        // 判断是不是，int 类型的，？？？
        System.out.println(int.class == Integer.TYPE);

        // 方法 就要想想有没有重载，下面方法，有重载。

        // 类 就这样获取Class 对象。
        Class<String> c = String.class;
        String s = new String("");
        // 对象 就这样获取Class 对象。
        Class<? extends String> c1 = s.getClass();
        // 通过全路径，来获取Class 对象。
        Class<?> c2 = Class.forName("java.lang.String");
        /**
         它们三个在创建实例的时候，都会去执行类加载，
         然后按照类加载 ，要执行的那些步骤开始执行。如：初始化静态代码块。
         */

    }
}
