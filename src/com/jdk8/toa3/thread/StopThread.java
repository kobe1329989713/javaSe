package com.jdk8.toa3.thread;

/**
 * Created by kobe on 2019/6/29.14:59
 *
 * @author kobe
 * <br/>
 * Description:
 * 停止线程。用标识变量来停止线程。
 */
class Thread4 implements Runnable{
    private boolean stop = false;

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {
        for (int i = 0; ; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (stop) {
                break;
            }
            System.out.println(i);
        }
    }
}
public class StopThread {
    public static void main(String[] args) throws Exception {
        Thread4 t4 = new Thread4();
        //new Thread(t4).start();

        Thread t5 = new Thread(t4);
        // 把t5 变成守护线程。注：它必须要在 start() 方法之前调用。
        // 因为它必须在执行之前知道它是什么线程。
        t5.setDaemon(true);
        t5.start();

        // 主线程执行了4秒后，停止t4 这个线程。
        Thread.sleep(4000);
        //t4.setStop(true);


    }
}
