package com.jdk8.toa4.date;

import java.time.Period;

/**
 * Created by kobe on 2019/6/16.2:45
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class PeriodDemo {
    public static void main(String[] args) {
        // 它也是表示一个 时间间隔的。它对用户更友好，它表示的不是那么精确。
        Period p1 = Period.of(1, 2, 20);
        System.out.println(p1);

        // 继续 加 或者 减 多少时间。
        System.out.println(p1.minusDays(21));
    }
}
