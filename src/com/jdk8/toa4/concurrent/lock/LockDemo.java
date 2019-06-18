package com.jdk8.toa4.concurrent.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by kobe on 2019/6/14.16:56
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class LockDemo {

    /**
     * ReentrantLock() 它就是一个可重入锁。
     * 看下面 test() 方法，它在锁中的代码 又加锁。
     * 本来会曹成死锁的。但是你用的是  ReentrantLock 它是可重入锁(重复用)
     * 所以不会出现该问题。重点看代码。
     */
    // 锁。
    Lock lock = new ReentrantLock();

    // 需要加锁的代码。
    public void print() {
        lock.lock();
        for (int i = 0; i < 50; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
        test();
        lock.unlock();
    }

    public void test() {
        lock.lock();
        System.out.println("test");
        lock.unlock();
    }

    public static void main(String[] args) {
        LockDemo demo = new LockDemo();
        // 没有加锁，就是并发的再进行。想打印结果，看打印结果。
        // 加了锁。它是一个一个线程执行的。
        new Thread(demo::print).start();
        new Thread(demo::print).start();

    }
}
