package com.jdk8.toa4.date;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * Created by kobe on 2019/6/16.2:33
 *
 * @author kobe
 * <br/>
 * Description:
 * 枚举：时间单位。
 */
public class UnitDemo {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        // 加四天。
        System.out.println(now.plus(4, ChronoUnit.DAYS));
        // 加四个星期。
        System.out.println(now.plus(4, ChronoUnit.WEEKS));
    }
}
