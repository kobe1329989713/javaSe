package com.jdk8.toa3.enum1;

/**
 * Created by kobe on 2019/6/20.3:48
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class TestEnum1 {
    public static void main(String[] args) {
        Season s = Season.S;

        // values();它可以得到一个枚举里面所有的变量，
        Season[] ss = Season.values();
        for (Season season : ss) {
            // 得到名字。
            System.out.println("得到名字。"+season.name());
            // 得到序号。从零开始。
            System.out.println("得到序号。"+season.ordinal());
        }
        // 通过名字得到 枚举。 必须要一模一样。
        Season s1 = Season.valueOf("S");
        System.out.println(s1.ordinal());
    }
}
