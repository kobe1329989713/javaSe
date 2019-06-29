package com.jdk8.toa3.thread;

/**
 * Created by kobe on 2019/6/29.16:41
 *
 * @author kobe
 * <br/>
 * Description:
 */

// 生产者。
class ProductorThread implements Runnable {
    private Resource resource;

    public ProductorThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.increse();
        }
    }
}

// 消费者。
class ConsumerThread implements Runnable {
    private Resource resource;

    public ConsumerThread(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            resource.decrese();
        }
    }
}

public class Resource {
    private int num = 0;

    // 生产
    // num 增加
    synchronized void increse() {
        // 什么情况下增加了？
        //if (num != 0) {
        // 不管几个线程进来 都要 进行判断。
        while (num != 0) {
            try {
                // wait() 它虽然是暂停的 但是 它的锁是释放了的。
                // 所以其它线程还是可以操作的。
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 等于0时 加。
        num++;
        // 通知消费者。
        notify();
        System.out.println("面包有：" + num);
    }

    // 消费
    // num 减少
    synchronized void decrese() {
        // 什么情况下增加了？
        //if (num == 0) {
        while (num == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 等于0时 加。
        num--;
        // 通知生产者。
        notify();
        System.out.println("面包有：" + num);
    }

    public static void main(String[] args) {
        Resource r = new Resource();
        // 启动生产者线程。
        for (int i = 0; i < 3; i++) {
            ProductorThread p = new ProductorThread(r);
            new Thread(p).start();
        }


        // 启动消费者线程。
        for (int i = 0; i < 30; i++) {
            ConsumerThread c = new ConsumerThread(r);
            new Thread(c).start();
        }

// 生产与消费 数量不一样了？

    }
}

