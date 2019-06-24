package com.jdk8.toa3.annotation;

/**
 * Created by kobe on 2019/6/23.7:54
 *
 * @author kobe
 * <br/>
 * Description:
 * 自定义注解
 *
 * 重点是如何把 加了注解的 东东，它内容(信息)给加载出来了。
 */
public @interface MyAnnotation1 {

}
// 使用。
@MyAnnotation1
class A01{

    @MyAnnotation1
    int num;

    @MyAnnotation1
    void m2() {

    }
}
