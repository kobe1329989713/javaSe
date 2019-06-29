package com.jdk8.toa3.gc;

/**
 * Created by kobe on 2019/6/29.17:34
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class GCDemo {
    static void createObjects(int num) {
        for (int i = 0; i < num; i++) {
            // 它就是一个垃圾，因为没有程序引用它
            // 它就会被 java的垃圾回收器，给回收掉。
            new Object();
        }
    }
    public static void main(String[] args) {
        // m1 可用内存
        // m2 创建完对象 之后 的内存
        // m2 垃圾回收 之后 的内存。
        long m1, m2, m3;
        Runtime r = Runtime.getRuntime();
        //System.out.println("得到可用内存的大小：" + r.freeMemory());
        for (int i = 0; i < 3; i++) {
            m1 = r.freeMemory();
            createObjects(20000);
            m2 = r.freeMemory();
            System.gc();
            m3 = r.freeMemory();
            System.out.println( "m1: " + m1 + "\t" + "m2: " + m2 + "\t" + "m3: " + m3);
        }
    }
}
