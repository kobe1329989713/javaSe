package com.jdk8.toa3.thread;

/**
 * Created by kobe on 2019/6/29.16:13
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class SysDeno1 {

    public synchronized void m1(){
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m1: " + i);
        }
    }

    //public synchronized void m2(){
    public synchronized static void m2(){
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("m2: " + i);
        }
    }

    public static void main(String[] args) {
        SysDeno1 d = new SysDeno1();
        new Thread(d::m1).start();
        new Thread(SysDeno1::m2).start();
    }
}
