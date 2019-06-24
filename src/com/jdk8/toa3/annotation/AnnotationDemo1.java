package com.jdk8.toa3.annotation;

/**
 * Created by kobe on 2019/6/23.7:42
 *
 * @author kobe
 * <br/>
 * Description:
 */
// 用于函数式接口。只有一个方法的函数。
@FunctionalInterface
interface Interface1{
    void m();
    //void m1();
}

@SuppressWarnings("all")
@Deprecated
public class AnnotationDemo1 {
    @Deprecated
    private Integer num;
    public static void main(String[] args) {
        AnnotationDemo1 ad = new AnnotationDemo1();
        //ad.num;
        System.out.println("");
        m1();
    }


    @Deprecated
    public static void m1() {

    }
}
