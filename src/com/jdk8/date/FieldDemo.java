package com.jdk8.date;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

/**
 * Created by kobe on 2019/6/16.2:28
 *
 * @author kobe
 * <br/>
 * Description:
 * 枚举：时间字段。
 */
public class FieldDemo {
    public static void main(String[] args) {
        LocalDateTime t = LocalDateTime.now();
        // ChronoField 这个枚举实现了  TemporalField 这个接口。
        // 你可以自己定义。你实现它的哪个接口就好。
        int i = t.get(ChronoField.YEAR);
        System.out.println(i);
        System.out.println(t.get(ChronoField.MONTH_OF_YEAR));
    }
}
