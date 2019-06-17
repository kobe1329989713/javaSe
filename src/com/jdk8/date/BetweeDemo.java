package com.jdk8.date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

/**
 * Created by kobe on 2019/6/16.2:49
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class BetweeDemo {
    public static void main(String[] args) {
        LocalDate d1 = LocalDate.of(2013, 12, 1);
        LocalDate d2 = LocalDate.now();
        // 看 这两个时间相差多少时间。
        long days = ChronoUnit.DAYS.between(d1, d2);
        System.out.println(days);
        // 相差多少月，其它时间，你修改这个枚举就好。
        long month = ChronoUnit.MONTHS.between(d1, d2);
        System.out.println(month);

        System.out.println(d1.until(d2));
        System.out.println(d1.until(d2,ChronoUnit.MONTHS));
        System.out.println(d1.until(d2,ChronoUnit.DAYS));


        // 日期 与 时间 是不能进行比较的。
        LocalTime t = LocalTime.now();
        //long t2 = ChronoUnit.MONTHS.between(d1, t);
        //System.out.println(t2);


        // 时间之间比较。
        LocalTime t1 = LocalTime.of(22, 10);
        // 相差多少分钟。
        System.out.println(ChronoUnit.MINUTES.between(t,t1));

        // 两个 日期之间比较。
    }
}
