package com.jdk8.toa4.format;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by kobe on 2019/6/16.4:05
 *
 * @author kobe
 * <br/>
 * Description:
 * 对数字 进行 格式化。
 */
public class NumberFormate {
    public static void main(String[] args) {
        NumberFormat f1 = NumberFormat.getNumberInstance(Locale.getDefault());
        // 美国
        //NumberFormat f1 = NumberFormat.getNumberInstance(Locale.US);
        // 法国
        //NumberFormat f1 = NumberFormat.getNumberInstance(Locale.FRENCH);
        System.out.println(f1.format(1234567890));

        // 和钱相关的格式化。
        // Locale.ENGLISH 英棒
        f1 = NumberFormat.getCurrencyInstance(Locale.FRENCH);
        System.out.println(f1.format(1234567890));


        // Decimal 数字的格式化。
        // ##.## 小数点后面只保留两位。有四舍五入的效果。
        DecimalFormat f2 = new DecimalFormat("##.##");
        System.out.println(f2.format(1234.566789));

        //  printf() 它可以格式化输出 字符串 数字 日期
    }
}
