package com.jdk8.toa3.thread;


@SuppressWarnings("ALL")
public class Account02 {
    private int money = 1000;

    public int getMoney() {
        return money;
    }

    // 取钱方法。 这里就是：临界区
    public void withdraw(int money) {
        if (money <= 0) {
            System.out.println("取款金额必须大于0");
            return;
        }
        if (money > this.money) {
            System.out.println("取款金额不能高于当前余额");
            return;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.money -= money;
        System.out.println("取款成功！取款：" + money);
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        // 现在就是线程不安全的，多个线程操作共享数据时，余额负2000都来了，
        // 就是因为加了线程，使几个线程同时在访问，所以你加的那些 if 判断没有起到作用。
        for (int i = 0; i < 10; i++) {
            Thread t1 = new Thread(new WithDrawThread(account));
            t1.start();
        }
        Thread.sleep(10000);
        System.out.println("余额：" + account.getMoney());
    }
}
