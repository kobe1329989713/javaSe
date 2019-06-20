package com.jdk8.toa3.generic;

import com.sun.xml.internal.ws.dump.MessageDumping;

/**
 * Created by kobe on 2019/6/19.20:20
 *
 * @author kobe
 * <br/>
 * Description:
 */
class Wrapper1<T>{
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
public class GenericDemo1 {

    /**
     * 先赋值 原生类型，在赋值 w1 就是堆污染，这样搞了以后肯定会有类型转换异常。
     * 因为泛型 之间是不能相互赋值的，如：w1 = w2 ，这种就是错误的。
     */

    // 这样做也会造成堆污染，它在运行时肯定会报 类型转换异常的。
    //@SafeVarargs 它是一个去除警告的一个注解。
    public static void test(Wrapper1<String>... ws) {
        // 因为转换Object 以后，你的那些功能也就没有了。
        Object[] objs = ws;
    }


    public static void main(String[] args) {
        Wrapper1<String> w1 = new Wrapper1<>();
        Wrapper1<Object> w2 = new Wrapper1<>();
        // String 与 Object 是父子关系。
        // 泛型不可以把 实参为子类的变量，传给实参为父类的类型。
        //w2 = w1;
        // 如果是一个继承关系，可以把子类的变量传递给父类，这叫 向上转型，泛型是不可以的。


        // 这是一种身后兼容的做法，叫原生版本。原生的类型。raw type
        // 它就没有泛型的功能了，
        Wrapper1 w3 = new Wrapper1();
        // 这样就可以。
        w2 = w3;
        w3 = w1;
        // 不推荐这样做。
        //如果泛型类，里面用一个泛型的数据，就会造成类型转换错误。因为它是T
        // 你不用泛型，它就不知道T的类型是什么所以就会错误。
        Wrapper1 w4 = new Wrapper1();
        w4.setData(new Integer(22));
        System.out.println(w4.getData());
        Wrapper1<String> w5 = new Wrapper1<>();
        w5 = w4;
        // 这时它就报类型转换异常了。
        //System.out.println(w5.getData());

        /**
         泛型 T，在你用泛型时，会被你传的具体的实参类给替换掉，这是不正确的。
         那个泛型类 Wrapper1，它会编译成一个Object类，就是把T 不管你传的是什么实参类
         全部都替换成Object。那个 T 只是在编译时，给你确定类型，让你只能传递什么类型的，
         但是在运行时，那个 T 会全部被替换成 Object 没有任何的类型信息。这个也叫类型的擦除。
         那个 Wrapper1 类 在运行会变成如下样子。

         class Wrapper1{
            private Object data;
            // get() set() 构造方法  其它方法，它们全部都是把 T 替换成了 Object
         }
         所以你在泛型类（Wrapper1)里面不能用 T 创建任何的实例
         如：T t = new T()  这种是不行的。结合上面想？？？
         因为这个是不确定的，在运行时全部被替换成了 Object 了。你new 肯定是没有什么用的。
        T[] t = new T{1] 也是 不行。
         */

        // 通过反射获取的类型，它们俩个都是一样的。
        System.out.println(w1.getClass().getName());
        System.out.println(w2.getClass().getName());
    }
}
