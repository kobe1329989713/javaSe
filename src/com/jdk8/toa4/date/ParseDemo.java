package com.jdk8.toa4.date;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by kobe on 2019/6/16.3:41
 *
 * @author kobe
 * <br/>
 * Description:
 * 把字符串 解析 时间。
 */
public class ParseDemo {
    public static void main(String[] args) {
        String now = "12/16/2014";
        LocalDate date = LocalDate.parse(now, DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        System.out.println(date);

        LocalDate p1= LocalDate.from(DateTimeFormatter.ofPattern("MM/dd/yyyy").parse(now));
        System.out.println(p1);

        LocalDate p2 = DateTimeFormatter.ofPattern("MM/dd/yyyy").parse(now, LocalDate::from);
        System.out.println(p2);
    }
}
