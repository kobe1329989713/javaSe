package com.jdk8.compare;

/**
 * Created by kobe on 2019/6/16.5:16
 *
 * @author kobe
 * <br/>
 * Description:
 * 比较。
 */
public class User implements Comparable<User> {
    int age;

    public User(int age) {
        this.age = age;
    }

    // 让 User 类 有了比较的能力。
    @Override
    public int compareTo(User o) {
        if (age > o.age) {
            return 1;
        } else if (age < o.age) {
            return -1;
        }
        return 0;
    }
}
