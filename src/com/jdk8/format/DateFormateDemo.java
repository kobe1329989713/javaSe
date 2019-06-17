package com.jdk8.format;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by kobe on 2019/6/16.3:57
 *
 * @author kobe
 * <br/>
 * Description:
 * 日期 格式化。
 */
public class DateFormateDemo {
    public static void main(String[] args) {
        //DateFormat f1 = DateFormat.getDateInstance(DateFormat.LONG, Locale.CHINESE);
        //DateFormat f1 = DateFormat.getDateInstance(DateFormat.SHORT, Locale.CHINESE);
        //DateFormat f1 = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.CHINESE);
        DateFormat f1 = DateFormat.getDateInstance(DateFormat.DEFAULT, Locale.US);
        System.out.println(f1.format(new Date()));


        // 自定义时间格式化。
        SimpleDateFormat f2 = new SimpleDateFormat("yyyy/MM/dd");
        f2.applyPattern("MM#dd#yyyy");
        System.out.println(f2.format(new Date()));
    }
}
