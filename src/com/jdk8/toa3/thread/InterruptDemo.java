package com.jdk8.toa3.thread;

/**
 * Created by kobe on 2019/6/29.14:46
 *
 * @author kobe
 * <br/>
 * Description:
 * 中断线程 interrupt() 方法。
 */
public class InterruptDemo {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();

        // 主方法里面的循环。
        for (int i = 0; i < 20; i++) {
            System.out.println("main--> " + i);
            Thread.sleep(300);
        }

        // 中断 t1 线程。,它会报错，因为前面有一个 sleep() 中断，所以它会报一个中断异常。
        t1.interrupt();
        // 它不会重置标识位。
        System.out.println(t1.isInterrupted());
    }
}
