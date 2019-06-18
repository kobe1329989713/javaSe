package com.jdk8.toa4.compare;

/**
 * Created by kobe on 2019/6/16.5:17
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class CompareDemo01 {
    public static void main(String[] args) {
        // 谁的年龄大，谁就比较大。
        User u1 = new User(10);
        User u2 = new User(20);

        if (u1.compareTo(u2) > 0) {
            System.out.println("u1>u2");
        } else if (u1.compareTo(u2) < 0) {
            System.out.println("u1  < u2");
        } else {
            System.out.println("u1==u2");
        }
    }
}
