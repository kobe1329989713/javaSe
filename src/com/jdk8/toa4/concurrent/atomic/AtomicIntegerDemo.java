package com.jdk8.toa4.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created by kobe on 2019/6/14.14:58
 *
 * @author kobe
 * <br/>
 * Description:
 * 原子操作 基本原理。
 *
 * 你是想要先计算在获取值呢？
 * 还是
 * 先计算 在获取值。
 */
public class AtomicIntegerDemo {
    public static void main(String[] args) {
        int num = 10;
        // 这种写法是没有原子操作的，
        //num++;

        // 它是有原子操作。
        AtomicInteger i1 = new AtomicInteger(num);
        // getAndIncrement() 它相当于是 num++ 操作，但是它能保证原子操作。
        System.out.println(i1.getAndIncrement());
        // num-- 操作。
        System.out.println(i1.getAndAccumulate(3,(x,y)->(x+y)));
        System.out.println(i1.get());
        /**
         getXxx() get开关的方法，都是先获取值，再对这个值进行操作。
         xxxGet() get结尾的方法，都是先进行计算，再来获取值。
         */
        // 先将 i1 减一个，再去获取值。
        System.out.println(i1.decrementAndGet());
        System.out.println(i1.updateAndGet(x -> x * x));


        // 原子 数组操作。
        int[] nums1 = {1, 2, 3, 4, 5};
        AtomicIntegerArray a = new AtomicIntegerArray(nums1);
        // 数组索引，加多少值，
        System.out.println(a.addAndGet(3,10));
        // 原子 数组操作，很多方法都是需要数组索引，来对数组中的某一个元素操作。
        System.out.println(a.accumulateAndGet(2, 10, (x, y) -> x * y));
        // 索引为2的元素， 加10，它不是加 它是按照 lamdbda 里面实现的逻辑，
        // 来对这个数做操作。


        // 原子 操作。引用类型。
        User user = new User();
        user.setScore(100);
        AtomicIntegerFieldUpdater<User> updater =
                AtomicIntegerFieldUpdater.newUpdater(User.class, "score");
        // 然后你就可以对引用类型做 原子操作了。
        // 把这个对象传进去。对这个值什么操作。这里是加200
        System.out.println(updater.getAndAdd(user, 200));
        /**
         * 要修改的那个属性不能是 private 修饰的。
         * 必须要加 volatile 修饰。
         */
        // 你必须要在获取下，才能看到结果。
        System.out.println(user.getScore());
    }
}
