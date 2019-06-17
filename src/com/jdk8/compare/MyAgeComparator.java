package com.jdk8.compare;

import java.util.Comparator;

/**
 * Created by kobe on 2019/6/16.5:28
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class MyAgeComparator implements Comparator<User> {
    @Override
    public int compare(User o1, User o2) {
        if (o1.age > o2.age) {
            return 1;
        } else if (o1.age < o2.age) {
            return -1;
        }
        return 0;
    }
}
