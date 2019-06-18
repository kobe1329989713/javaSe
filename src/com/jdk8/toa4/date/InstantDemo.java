package com.jdk8.toa4.date;

import java.time.Duration;
import java.time.Instant;

/**
 * Created by kobe on 2019/6/16.2:06
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class InstantDemo {

    public static void main(String[] args) {
        // 从 1970-01-01 到 1000秒 这个时间
        Instant i1 = Instant.ofEpochMilli(1000);
        System.out.println(i1);

        // 当前时间。
        Instant i2 = Instant.now();
        // 它用的不是当前的时区，所以打印出来的时间不对。
        System.out.println(i2);
// i1 i2 ,它表示的是时间线上的的某一点，所以它打印的是 年 月 日 时 分 秒 毫秒。


        // 时间间距。
        // 相隔三天。
        Duration d1 = Duration.ofDays(3);
        // 相隔多少分钟。
        Duration d2 = Duration.ofMinutes(30);
        System.out.println(d1);
        System.out.println(d2);
// d1 d2 它表示的是是时间的间距，所以它表示的是，多少天 多少年 多少小时，这种。
// 这两个类 适合机器处理，不合适，人来读。


        // 时间过去了的是 前。
        System.out.println(i1.isAfter(i2));
        System.out.println(i1.isBefore(i2));
    }

}
