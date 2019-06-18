package com.jdk8.toa4.date;

import java.time.Year;
import java.time.YearMonth;

/**
 * Created by kobe on 2019/6/16.2:59
 *
 * @author kobe
 * <br/>
 * Description:
 * 部分时间。
 * 2019/01/01 22：22：22。22     只在得到其中的 年 月 日 时 分 秒 ，其中的的 一个 或者是一部分，这个就是部分时间。
 */
public class PartialDemo {
    public static void main(String[] args) {
        // 它也有 加 或 减 年。
        // 看它是不是湍年
        Year y = Year.of(2014);
        // 年 月。
        YearMonth ym = YearMonth.of(2014, 12);
        // 其它也是这样。
    }
}
