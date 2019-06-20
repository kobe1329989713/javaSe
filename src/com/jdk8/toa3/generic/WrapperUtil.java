package com.jdk8.toa3.generic;

/**
 * Created by kobe on 2019/6/19.21:59
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class WrapperUtil {

    public static void print(ObjectWrapper<Object> wrapper) { }

    // 泛型的通配符。？是未知的。
    public static void print1(ObjectWrapper<?> wrapper) { }

    // 上边界。
    // 限定 wrapper 获取的值是 它 或者 它的子类。
    // 它得到的 Object
    //public static void getValue(ObjectWrapper<?> wrapper) {
    // 它得到的是 Number 只能使用Number类。 不通用。
    //public static void getValue(ObjectWrapper<Number> wrapper) {
    // 是 Number 或者它的子类都是可以的。
    public static void getValue(ObjectWrapper<? extends Number> wrapper) {
        int v = wrapper.getData().intValue();
        System.out.println(v);
    }

    // 下边界。
    //只能是它，或者它的父类。
    // ？的类型，只能是 T ，或者它的父类。
    public static <T> void copy(ObjectWrapper<? super T> wrapper) {
        System.out.println(wrapper.getData());
    }
    // 它的使用。

}
