package com.jdk8.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.*;

/**
 * Created by kobe on 2019/6/16.3:07
 *
 * @author kobe
 * <br/>
 * Description:
 *
adJustInto()  带有 返回一个时间，的第多少 时间
一个找时间的规则。 */
public class AdjusterDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);

        // 当前时间的下个星期一是
        LocalDate d = now.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        System.out.println(d);

        // 这个月的第三个星期二
        LocalDate d2 = now.with(TemporalAdjusters.dayOfWeekInMonth(3, DayOfWeek.TUESDAY));
        System.out.println(d2);

        // 它可以用 lamdba 和方法引用。
        // 当前时间的 三个月 过两天。
        TemporalAdjuster adjuster = TemporalAdjusters.ofDateAdjuster(
                (LocalDate date) -> date.plusMonths(3).plusDays(2)
        );
        System.out.println(d.with(adjuster));




        // 查询。
        TemporalQuery<LocalDate> d5 = TemporalQueries.localDate();
        // 当前时间查询，d5 这个时间。
        System.out.println(now.query(d5));

        // 查询 当前这个时间所以支持的最小时间单位是
        TemporalQuery<TemporalUnit> d6 = TemporalQueries.precision();
        System.out.println(now.query(d6));

        LocalTime localTime = LocalTime.now();
        // Nanos 纳秒。
        System.out.println(localTime.query(d6));
    }
}
