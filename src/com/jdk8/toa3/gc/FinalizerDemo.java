package com.jdk8.toa3.gc;

/**
 * Created by kobe on 2019/6/29.17:45
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class FinalizerDemo {
    private int id;

    public FinalizerDemo(int id) {
        this.id = id;
    }

    // 在对象回收之前会执行 finalize() 方法。
    @Override
    protected void finalize() throws Throwable {
        // 是 10 的倍数
        if (id % 10 == 0) {
            System.out.println(id);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new FinalizerDemo(i);
        }
        System.gc();
    }
}
