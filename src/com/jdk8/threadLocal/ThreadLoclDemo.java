package com.jdk8.threadLocal;

/**
 * Created by kobe on 2019/6/14.18:42
 *
 *
 *
 * @author kobe
 * <br/>
 * Description:
 * ThreadLoal 在每一个线程里面 维护一个单列对象(变量)。数据库连接池，就是每一个线程维护一个数据库连接。
 * 先从其实例中取值
 * 没有取到值的话，先设置值。
 * 取到值的话，则返回回来使用之。
 */
public class ThreadLoclDemo {

    // 可以把 Integer 换成 数据库连接。
    private static ThreadLocal<Integer> t = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return super.initialValue();
        }
    };

    // initialValue() withInitial() 都是设置初始值


    public static void test() {
        //t.withInitial()
        Integer num = t.get();
        if (num == null) {
            num = 10;
            t.set(num);
        }
        // 删除这个值。
        //t.remove();
        System.out.println(num);
    }

    public static void main(String[] args) {
        test();
        test();
    }
}
