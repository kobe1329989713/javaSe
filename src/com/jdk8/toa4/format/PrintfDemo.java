package com.jdk8.toa4.format;

/**
 * Created by kobe on 2019/6/16.4:20
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class PrintfDemo {
    public static void main(String[] args) {
        // 这种就叫普通索引。
        // 只能多，不能少。
        System.out.printf("%s,%s,%s","a","b","c","dd");
        System.out.println("=");


        // 显示索引。
        System.out.printf("%1$s,%3$s,%3$s","a","b","c","dd");


        System.out.println("=");


        // 相对索引。
        System.out.printf("%1$s,%<s,%<s", "a", "b", "c", "dd");

        System.out.println("=");

        System.out.printf("%s", "a");
        System.out.println();

        // 在前面补空格，来形成 四位的长度。
        System.out.printf("%4s", "a");
        System.out.println("=");
        // 空格补在后面。
        System.out.printf("%-4s", "a");

        System.out.println("=");


        System.out.printf("%6d", 123);
        System.out.println("=");
        System.out.printf("%-6d", 123);
        System.out.println("=");
        // 把空格 补0
        System.out.printf("%06d", 123);

        System.out.println("=");


        // 把它括起来。
        System.out.printf("%(d\n", -123);

        System.out.println();

    }
}
