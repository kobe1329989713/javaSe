package com.jdk8.toa4.math;

import java.util.Random;

/**
 * Created by kobe on 2019/6/16.5:00
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class MathDemo {
    public static void main(String[] args) {
        // 绝对值
        System.out.println(Math.abs(-12.34));
        // 往上取整
        System.out.println(Math.ceil(1.9));
        // 往下取整。
        System.out.println(Math.floor(1.9));
        System.out.println(Math.max(12,10));
        System.out.println(Math.min(12,10));

        // 随机数
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random());
        }


        System.out.println("------------------------------");

        //Random r1 = new Random();
        Random r1 = new Random(10);
        // 得到一个随机的整数，也有其它类型的随机数。
        System.out.println(r1.nextInt());
        // 范围随机数，产生的是 0 到 9 任意的一个随机数。
        for (int i = 0; i < 10; i++) {
            System.out.println(r1.nextInt(10));
        }
        System.out.println("===========");

        // 10 到 20 的随机数。包括 10  20
        for (int i = 0; i < 10; i++) {
            System.out.println(r1.nextInt(11)+10);
        }


    }
}
