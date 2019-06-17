package com.jdk8.date;

import java.time.Clock;
import java.time.Instant;

/**
 * Created by kobe on 2019/6/16.2:39
 *
 * @author kobe
 * <br/>
 * Description:
 * Clock 获取某个 时区的 日期 日间。
 */
public class ClockDemo {
    public static void main(String[] args) {
        // 默认时区。
        Clock c = Clock.systemDefaultZone();
        System.out.println(c.getZone());

        // 得到某个时区，它的某个时间点。
        Instant i = c.instant();
        Instant i2 = Instant.now(c);
    }
}
