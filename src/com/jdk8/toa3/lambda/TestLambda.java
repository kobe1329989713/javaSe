package com.jdk8.toa3.lambda;

/**
 * Created by kobe on 2019/6/28.5:17
 *
 * @author kobe
 * <br/>
 * Description:
 */
// 函数式接口。
@FunctionalInterface
interface Addable {
    int add(int num1, int num2);
}
interface Divable{
    int div(int num1, int num2);
}
interface Divable1{
    String div(String num1, String num2);
}
interface Divable2{
    String div(String num1);
}
interface Divable3{
    void div(String num1);
}
interface Divable4{
    void div();
}

interface Divable5{
    void div();
}
public class TestLambda {
    public static void main(String[] args) {
        //Addable a = new Addable() {
        //    @Override
        //    public int add(int num1, int num2) {
        //        return 0;
        //    }
        //};

        // lambda
        //Addable a = (int num1,int num2)->{ return num1 + num2;};
        //Addable a = (int num1,int num2)->{ return num1 + num2;};
        //Addable a = Integer::sum;


        // 这两个函数式接口一模一样，是如何区分的？
        //Addable a = (int num1,int num2)->{ return num1 + num2;};
        //Divable b = (int num1,int num2)->{ return num1 + num2;};

        Addable a = (num1,num2)-> num1 + num2;
        Divable b = (num1,num2)-> num1 + num2;
        Divable1 d1  = (num1,num2)-> num1 + num2;
        System.out.println(a.add(2,2));
        System.out.println(b.div(4,4));
        System.out.println(d1.div("ko","be"));

        // lambda 表达式只有一个参数，可以省略 （） 小括号。
        //Divable2 d2 = (String msg) -> {return msg+"abc";};
        Divable2 d2 = msg ->  msg+"abc";
        String mar = d2.div("mar_");
        System.out.println("mar: "+mar);

        // 没有返回值。
        Divable3 d3 = msg -> {
            System.out.println(msg);
        };

        // 没有参数时，（） 小括号是不能省略的。
        Divable4 d4 = () -> System.out.println("没有参数");

        // 参数有修饰符，你的参数就不能省略了。
        Addable a1 = (final int num1,final int num2)-> num1 + num2;
        //System.out.println();
    }
}
