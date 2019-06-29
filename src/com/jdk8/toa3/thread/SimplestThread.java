package com.jdk8.toa3.thread;

/**
 * Created by kobe on 2019/6/29.12:54
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class SimplestThread {
    public static void main(String[] args) {
        Thread simplestThread = new Thread();
        // 开始启动线程，它会去执行 run() 方法里面的代码。
        // 当run()里面的代码执行完毕，这个线程也就执行完毕了。
        simplestThread.start();
        //simplestThread.run(); 这样错错。。。
        // 查看线程处于什么状态。
        System.out.println(simplestThread.getState());


        // 线程组。
        ThreadGroup tg1 = new ThreadGroup("ThreadGroup");
        // 创建线程并起名 并把线程放到 tg1 这个线程组里面。
        Thread t1 = new Thread(tg1, "threadName");


        // 获取当前运行的线程。
        Thread ct = Thread.currentThread();
        System.out.println(ct.getName());
        System.out.println(Thread.currentThread().getName());
    }
}
