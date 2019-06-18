package com.jdk8.toa4.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.TextStyle;
import java.time.temporal.ChronoField;

/**
 * Created by kobe on 2019/6/16.3:27
 *
 * @author kobe
 * <br/>
 * Description:
 * 把时间转换成字符串
 */
public class FormatDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        // 支持各种标准的 时间格式。
        System.out.println(DateTimeFormatter.ISO_DATE.format(now));
        System.out.println(now.format(DateTimeFormatter.ISO_DATE));

        // 输出自定义格式。
        DateTimeFormatter f1 = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
        System.out.println(f1.format(now));


        DateTimeFormatter f2 = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒");
        System.out.println(f2.format(LocalDateTime.now()));


        DateTimeFormatter f3 = new DateTimeFormatterBuilder()
                .appendValue(ChronoField.YEAR)
                .appendLiteral("年的圣诞节是")
                .appendText(ChronoField.DAY_OF_WEEK, TextStyle.FULL_STANDALONE)
                .toFormatter();
        LocalDate d = LocalDate.of(2014, 12, 25);
        System.out.println(f3.format(d));
    }
}
