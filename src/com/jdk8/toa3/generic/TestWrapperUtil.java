package com.jdk8.toa3.generic;

/**
 * Created by kobe on 2019/6/19.22:00
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class TestWrapperUtil {
    public static void main(String[] args) {
        ObjectWrapper<Object> w1 = new ObjectWrapper<>("hello");
        WrapperUtil.print(w1);

        ObjectWrapper<Integer> w2 = new ObjectWrapper<>(100);
        w2.setData(22);
        // 因为泛型之间是不能相互赋值的，所以这里报错。
        //WrapperUtil.print(w2);
        // 因为这个方法它那里是未知的，所以可以把 w2 传递进去。
        // 它就相当于不是两个泛型样。
        WrapperUtil.print1(w2);


        // 可以这样做但是不推荐。可以申明变量，但是不能使用。
        //ObjectWrapper<?> w3 = new ObjectWrapper<Long>(2L);
        // 它不能进行赋值。
        //w3.setData(22L);
        // 这样可以，但是没有什么用。
        //w3.setData(null);

        ObjectWrapper<Short> w4 = new ObjectWrapper<>((short) 1);
        WrapperUtil.getValue(w4);


        ObjectWrapper<Object> w6 = new ObjectWrapper<>("abc");
        WrapperUtil.copy(w6);
    }
}
