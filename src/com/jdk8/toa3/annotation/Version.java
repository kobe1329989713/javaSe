package com.jdk8.toa3.annotation;

import com.jdk8.toa3.enum1.Season;

/**
 * Created by kobe on 2019/6/23.8:06
 *
 * @author kobe
 * <br/>
 * Description:
 * 看到注释 02
 */
public @interface Version {
    // 注释里面的属性，它很像申明一个方法样。
    // 大小版本。
    int big();
    int small();
    String name() default "defaultValue";
    Class C() default String.class;
    MyAnnotation1 A() default @MyAnnotation1;
    Season s() default Season.S;
    int[] nums() default {1,2,3,4};
}
// 使用。
@Version(big = 2,small = 1)
class TestVersion{
    public static void main(String[] args) {
        //
        System.out.println();
        System.out.println();
    }

    public void m1() {

    }
}
