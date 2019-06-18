package com.jdk8.toa4.math;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by kobe on 2019/6/16.4:36
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class BigDemo {
    public static void main(String[] args) {
        // 这么长就会报错。要么专门处理 长数据的类型。BigDecimal
        // 它是无法保存的。
        //long l = 4444444444444444444444444444444444444444;

        BigDecimal d1 = new BigDecimal("555555555555555555555555555555555555555555555555555555555");
        BigDecimal d3 = new BigDecimal("555555555555555555555555555555555555555555555555555555555");
        // 它用科学记数法，来打印出来。
        //System.out.println(d1.doubleValue());
        //System.out.println(d1.toString());
        //System.out.println(d1.toPlainString());

        // 相加。
        System.out.println(d1.add(d3));
        // 减
        System.out.println(d1.subtract(d3));
        // 乘
        System.out.println(d1.multiply(d3));
        // 除
        System.out.println(d1.divide(d3,d1.scale()));


        //BigDecimal d2 = new BigDecimal("12.34", new MathContext(1));
        BigDecimal d2 = new BigDecimal("12.36",
                new MathContext(3, RoundingMode.HALF_UP)
        );
        System.out.println(d2.toPlainString());


        System.out.println("==============================================================");


        BigInteger i1 = new BigInteger("111111111111111111111111111111111111111111111111111111111111111");
        BigInteger ir = new BigInteger("111111111111111111111111111111111111111111111111111111111111111");
        System.out.println(i1.add(ir));

        // 1 表示前面 1位 ,UP 往上取整，5.1 它取的还是 6
        // DOWN 往下取整。5.9 它取的还是 5
        // 还有其它枚举。
        BigDecimal d4 = new BigDecimal("5.9", new MathContext(1, RoundingMode.DOWN));
        System.out.println(d4);


    }
}
