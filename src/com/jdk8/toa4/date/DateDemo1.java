package com.jdk8.toa4.date;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by kobe on 2019/6/16.0:30
 *
 * @author kobe
 * <br/>
 * Description:
 * jdk8 以前处理 日期 时间的 方式。
 * 它有一定的局限性，所以就有了新的 日期 时间 api 了。
 * 那个时间在前，那个时间在后，画时间线，来看。
 */
public class DateDemo1 {

    public static void main(String[] args) {
        Date d = new Date();
        System.out.println(d.getTime());

        Date d1 = new Date();
        d1.setTime(1560616360120L);
        System.out.println(d1.getTime());

        // 那个时间在前 那个在后。
        System.out.println(d.after(d1));
        System.out.println(d.before(d1));

        // Calendar 它能得到 年 月 日 时 分 秒
        // 得到当前时区 当前国家 的一个时间点
        Calendar c = Calendar.getInstance();
        // 这个 get() 可以得到 各种 日期 时间，只要给他传递不同的 常量就行。
        System.out.println(c.get(Calendar.YEAR));
        // 月要加 + 1
        System.out.println(c.get(Calendar.MONTH)+1);
        // Calendar 它能表示 AM上午 PM下午  AUGUST月份
        // DAY_OF_WEEK 这个月的第几天。或者这个星期的第几天(得到星期几)。


        // 在某个时间上，在加上某个时间。
        // 当前时间，加上7天。
        c.add(Calendar.DATE,7);
        // 减 7 天
        //c.add(Calendar.DATE,-7);
        // 如果你加的是   年 或者 月，这些，你就改变前面的常量就好。
        System.out.println(c.get(Calendar.DATE));

        // roll 也是一个加多少 时间的 方法。
        // roll() 它不会进位，如 你加的天数，到了下月了，add() 会自动进位，或者是 减少。
        // roll() 就没有自动进位功能。
        c.roll(Calendar.DATE,20);
        System.out.println(c.get(Calendar.DATE));

        // true 自动加+1，false 减一。
        // boolean 参数的，自动的进行 加一 减一操作。
        c.roll(Calendar.DATE,true);
    }
}
