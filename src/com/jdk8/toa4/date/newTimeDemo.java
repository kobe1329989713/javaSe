package com.jdk8.toa4.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * Created by kobe on 2019/6/16.1:09
 *
 * @author kobe
 * <br/>
 * Description:
// 持续 1年 2个月 3天 T 四小时 5分钟 6秒
// 它的持续时间表示如下：
// P1Y2M3DT4H5M6S
 */
public class newTimeDemo {

    public static void main(String[] args) {
        // 只创建当前的 日期，不要时间。
        // 旧的时间api 做不到，旧的时间api 它每次都是日期与时间同时出现的。

        // 只想要日期。
        // 它里面只有 年 月 日
        // 它是不能通过 new 来创建实例的。
        LocalDate d = LocalDate.now();
        // getDayOfMonth() 这个月的第几天。
        // getMonth() 打印的是一个英文的月
        // getMonthValue() 它打印的就是 数字的月。
        System.out.println(
                d.getYear()+"\t"+
                d.getMonth()+"\t"+
                d.getDayOfMonth()+"\t"+
                d.getMonthValue()
        );
        System.out.println(d);


        // 只有时间。
        LocalTime t = LocalTime.now();
        System.out.println(t);


        // 有 日期 和 时间。
        LocalDateTime dt = LocalDateTime.now();
        System.out.println(dt);


        // 得到某个特定的时间。
        LocalDate d1 = LocalDate.of(2012, 12, 3);
        LocalTime t1 = LocalTime.of(12, 4, 7);
        System.out.println(d1);
        System.out.println(t1);
        // ofSecondOfDay() 这一天过去了多少秒的一个时间。
        LocalTime t2 = LocalTime.ofSecondOfDay(1000);
        System.out.println(t2);
    }

}
