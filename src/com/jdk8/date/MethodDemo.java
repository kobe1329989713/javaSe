package com.jdk8.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * Created by kobe on 2019/6/16.1:27
 *
 * @author kobe
 * <br/>
 * Description:
 *  新的时间api 一些通用方法介绍。
 *
// 它也可以传 时间单位 枚举。
 它很灵活。
 */
public class MethodDemo {

    public static void main(String[] args) {

        //LocalDate d1 = LocalDate.of(2014, 12, 25);
        // 用月份枚举的形式。
        LocalDate d1 = LocalDate.of(2014, Month.JANUARY, 25);
        System.out.println(d1);


        LocalDateTime t1 = LocalDateTime.of(2013, 1, 3, 11, 57, 44);
        // from()，从一个 日期 时间 得到 一个时间。或者是一个 日期。
        System.out.println(LocalDate.from(t1));
        System.out.println(LocalTime.from(t1));


        // withXxx() 修改一个 时间 日期 其中的某一个，其它的不变。
        // 2019-01-24 11:57:11.432  ,它可以只修改 其中某个值，其它不变。
        LocalDate d2 = d1.withYear(2015).withMonth(3);
        System.out.println(d2);



        // 得到一个 时间的，特定值，如：2019-01-24 11:57:11.432，我只想得到 其中某个值。
        System.out.println(d2.getYear()+","+d2.getMonthValue());



        // toXxx()相对某个时间，到现在 一共相差了多少天。
        long days = d2.toEpochDay();
        System.out.println(days);

        // 相差多少 时间。
        LocalTime t2 = t1.toLocalTime();
        System.out.println(t2);

        // 对某个时间 进行  加 减 操作。
        LocalDateTime t3 = d2.atTime(12, 25);
        System.out.println(t3);

        // 返回一个时间的开始。如：2019-01-24 11:57:11.432  它只获取 2019-01-24
        System.out.println(d2.atStartOfDay());


        System.out.println(d2);
        // plusXXX()对某个时间 加
        // 如：加五天
        System.out.println(d2.plusDays(5));
        // 负数，就是减多少时间。
        // 它也可以传 时间单位 枚举。
        System.out.println(d2.plusDays(-5));
        // minusXXX()对某个时间 减。
        System.out.println(d2.minusDays(-2));
        System.out.println(d2.minusDays(2));


        // 代表月份的，它有一个专门的枚举类，来表示。

        // ofEpochDay() 它是以 1970年1月1号做为基准的一个天数，如：你传的是10 就是 1970/01/11
        //LocalDate t1 = LocalDate.ofEpochDay(10);
        // ofYearDay() 传一个年和多少天，如：你 2014年，10天，得到的就是 2014/01/10
        //LocalDate t1 = LocalDate.ofYearDay(2014,10);
        //System.out.println(t1);
    }

}
