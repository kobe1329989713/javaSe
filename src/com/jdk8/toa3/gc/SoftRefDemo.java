package com.jdk8.toa3.gc;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kobe on 2019/6/29.17:54
 *
 * @author kobe
 * <br/>
 * Description:
 * 软引用。
 */
class BigObject{
    private long[] nums = new long[4096];
    private long id;

    public BigObject(long id) {
        this.id = id;
    }

    // ??? 为什么要重写它呢？？？
    @Override
    protected void finalize() throws Throwable {
        System.out.println(id + ": 被回收");
    }
}
public class SoftRefDemo {
    public static void main(String[] args) {
        BigObject b1 = new BigObject(0);
        // SoftReference 放入它里面的就是 软引用
        SoftReference<BigObject> sr = new SoftReference<>(b1);
        // 这样 就是解除强引用 了。
        b1 = null;

        // 强 软 虚 弱  这四个引用，它们都有各自的 特点。


        List<BigObject> list = new ArrayList<>();
        // 报 内存 不够用了，内存溢出。
        long i = 1;
        while (true) {
            list.add(new BigObject(i++));
        }
    }
}
