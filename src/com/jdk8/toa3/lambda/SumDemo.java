package com.jdk8.toa3.lambda;

/**
 * Created by kobe on 2019/6/27.6:57
 *
 * @author kobe
 * <br/>
 * Description:
 * lambda 表达式，
 * 问题：计算整形数组中所有元素之和，是偶数的元素之和，是3的倍数的元素之和。
 * 如果用一般编程来解决这个问题，你会写很多方法来到达这个要求。
 * 而
 * 如果用 lambda 表达式来解决这个问题，只需要根据你的需求把 要求什么的之和用参数的形式
 * 传递给lamdba 就好。想想它是怎么实现的，有一个策略接口。
 */
// 策略接口。
interface Policy{
    boolean test(int num);
}
public class SumDemo {
    // 用普通的这种实现方法要写太多，用 lambda 表达式，直接传代码。？？
    //static int add1(int[] nums) {
    //    int r = 0;
    //    for (int num : nums) {
    //        // 这里就要根据需求判断，它是什么数时，才进行求和。
    //        if (num % 2 == 0) {
    //            r += num;
    //        }
    //    }
    //    return r;
    //}
    // …… 等要写很多，大大的不好。


    // lambda实现。
    static int add(int[] nums, Policy p) {
        int r = 0;
        for (int num : nums) {
            if (p.test(num)) { // ****
                r += num;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6};
        // 就把判断的逻辑给传递进去，这样你只需要写一个方法就好，
        // 然后把具体需要求什么数之和的逻辑给当成方法参数样，给传递进方法里。
        int add = add(nums, num -> num % 2 == 0);
        // 是不是3的倍数。
        int add1 = add(nums, num -> num % 3 == 0);
        int add2 = add(nums, num -> num % 4 == 0);
        // ……
        // 就很方便了。
        System.out.println("add1: " + add + "\t" + "add: " + add + ", add2: " + add2);
    }


}
