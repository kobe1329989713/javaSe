package com.jdk8.toa3.thread;

/**
 * Created by kobe on 2019/6/29.16:13
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class SysDeno2 {

    public void m1(){
        // 同步块。
        synchronized (this) {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("m1: " + i);
            }
        }
    }

    //public synchronized void m2(){
    public void m2(){
        // 这个this 是一个对象，也可以换成其它对象，你对那个对象加锁。如：“” 空字符串
        // 两个对象都不一样，所以 m1 m2 这两个方法，就不同步了。
        //synchronized (this) {
        synchronized ("") {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("m2: " + i);
            }
        }
    }

    public static void main(String[] args) {
        SysDeno2 d = new SysDeno2();
        new Thread(d::m1).start();
        new Thread(d::m2).start();
    }
}
