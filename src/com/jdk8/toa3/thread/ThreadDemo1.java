package com.jdk8.toa3.thread;

/**
 * Created by kobe on 2019/6/29.13:06
 *
 * @author kobe
 * <br/>
 * Description:
 */
class Thread1 extends Thread{
    private int num;

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + "\t" + "num: " + num);
        }
    }
}

class Thread2 implements Runnable{
    private int num;

    public Thread2() { }

    public Thread2(int num) {
        this.num = num;
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        // 设置名字
        ct.setName("设置线程名字");
        System.out.println("得到当前的线程："+ct.getName());
        // 设置优先级。
        //ct.setPriority(10);
        ct.setPriority(Thread.MAX_PRIORITY);
        System.out.println("得到当前的线程 的优先级："+ct.getPriority());

        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread2-> "+i + "\t" + "num: " + num);
        }
    }
}

public class ThreadDemo1 {
    public static void main(String[] args) throws InterruptedException {
        /**
         这个 main() 肯定是一个线程 它是一个主线程。
         t1 是 主线程里面的子线程。
         所以这里是两个线程。
         它们是同时在执行。看它们打印的执行结果，它不是等 t1 或者是主线程执行完了
         才执行下一个线程的。它们两个是在不停的切换cup 的，所以看到的结果是 主线程的有
         子线程有。这种，它们是在不停的切换cpu 相当于是在同时执行样。因为速度太快。
         所以每次执行打印的结果都是不一样的。
         在两个线程中个加一个睡眠的方法，就可以看到它们是在不停的切换cpu了。
         */
        Thread1 t1 = new Thread1();
        // start() 调用 run() 方法。
        // setXxx() 方法给线程里面的属性赋值。
        t1.setNum(100);
        t1.start();
        // 它会等，t1 输出完了以后在执行下面的语句。
        // 它有重载需要：毫秒，纳秒，
        // 等过 xx毫秒 纳秒 在进行join() 操作。
        t1.join();

        // 子线程02。 构造赋值。
        // Runnable 是函数式接口。
        Runnable r2 = new Thread2(200);
        Thread t2 = new Thread(r2);
        t2.start();
        t2.join();


        // 主线程执行的代码。
        for (int i = 0; i < 20; i++) {
            Thread.sleep(500);
            System.out.println("main: " + i);
        }


/**
 让线程有顺序的执行，第一个线程执行完了，执行第二个线程，在执行第三个线程，在执行第四个线程
 xx.join()  它能办到。
  */

        // lambda表达式 和 方法引用就不好传参了 。
        // lambda表达式创建一个线程。
        //Thread t3 = new Thread(()->{
        //    for (int i = 0; i < 20; i++) {
        //        try {
        //            Thread.sleep(400);
        //        } catch (InterruptedException e) {
        //            e.printStackTrace();
        //        }
        //        System.out.println("thread3--> "+i);
        //    }
        //});
        //t3.start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread3--> "+i);
            }
        }).start();


        // 方法引用 来搞一个线程。
        // 方法引用是 没有参数和返回值的。
        new Thread(ThreadDemo1::print).start();
    }

    static void print() {
        for (int i = 0; i < 20; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread4--> "+i);
        }
    }
}
