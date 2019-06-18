package com.jdk8.toa4.date;

import java.time.LocalDate;
import java.time.Month;

/**
 * Created by kobe on 2019/6/16.2:22
 *
 * @author kobe
 * <br/>
 * Description:
 * 与时间相关的枚举类。
 */
public class MonThDemo {

    public static void main(String[] args) {
        Month m = Month.OCTOBER;
        LocalDate d = LocalDate.of(2013, m, 12);

        // 用来做比较，它们俩个都是字符串了。
        Month m1 = Month.of(10);
        System.out.println(m1==m);

        // 加一个月。
        System.out.println(m1.plus(1));
        System.out.println(m1.plus(1).getValue());

        System.out.println(Month.from(d).getValue());


    }

}
