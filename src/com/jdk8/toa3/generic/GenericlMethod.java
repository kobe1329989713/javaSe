package com.jdk8.toa3.generic;

/**
 * Created by kobe on 2019/6/19.21:03
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class GenericlMethod<T> {


    // 构造方法使用泛型。
    public <V> GenericlMethod(V v){

    }

    public GenericlMethod() { }

    // 泛型方法。
    public <V> void m() {
        // 如果你指定泛型以后你没有使用它，那么它就和变通方法是一样的。它就是一个变通方法而已。
        System.out.println("// 泛型方法。");
    }

    // 用泛型方法 就是在方法参数类型，或者是在方法体内使用那个 V 就是在使用泛型了。
    public <V> void m1(V v,T t) {
        System.out.println("使用泛型方法。" + v.toString());
        // 方法里面还可以使用 类 上面的 泛型T
    }

    // 带有返回值的泛型方法。
    public <V> T m3(V v, T t) {
        System.out.println("带有返回值的泛型方法。"+v.toString());
        return t;
    }

    // 静态加带有返回值的 泛型方法，
    // 注：静态泛型方法是无法使用，类上的泛型 T 的，因为是静态方法调用是通过类名点 你泛型都不能传，所以肯定不能使用
    public static <V> V m2(V v) {
        System.out.println("静态加带有返回值的 泛型方法，");
        return v;
    }

    public static void main(String[] args) {
        // 使用泛型构造
        // 类型要写三遍。
        // 中间哪个泛型是 构造方法的泛型。V
        // 前后两个泛型是 泛型类，上面的哪个 T
        GenericlMethod<String> s3 = new <String>GenericlMethod<String>("kobe");
        GenericlMethod<Integer> s4 = new <Integer>GenericlMethod<Integer>(22);
        GenericlMethod<Integer> s5 = new <Long>GenericlMethod<Integer>(22L);
        GenericlMethod<Integer> s6 = new <Boolean>GenericlMethod<Integer>(true);



        String s1 = GenericlMethod.m2("static V");
        System.out.println(s1);
        Integer s2 = GenericlMethod.m2(22);
        System.out.println(s2);

        GenericlMethod<Integer> s = new GenericlMethod();
        s.m();
        s.m1("VVV",20);
        s.m1(2,20);
        s.m1(true,20);
        // 也可以这样调用。
        //s.<String>m1("vvv");

        s.m3(false, 1993);


    }


}
