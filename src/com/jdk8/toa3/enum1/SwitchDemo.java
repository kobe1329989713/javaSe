package com.jdk8.toa3.enum1;

/**
 * Created by kobe on 2019/6/20.4:00
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class SwitchDemo {

    public static String getSeason(Season s) {
        switch (s) {
            case S:
                return "S";
            case A:
                return "A";
            case W:
                return "w";
            case S1:
                return "s1";
            default:
                return "default";
        }
    }

    public static void main(String[] args) {
        //System.out.println(getSeason("sss"));
        //System.out.println(getSeason(null));
        //System.out.println(getSeason(Season.S));


        // 枚举调用方法。
        //Season1 s = Season1.S;
        //Season1 s = Season1.S1;
        //System.out.println(s.getName());


        // 调用枚举里面的抽象方法。
        //Season2 s1 = Season2.S;
        //s1.m2();


        // 枚举的比较
        Season2 s1 = Season2.S1;
        Season2 s2 = Season2.S;
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(Season2.S));
        System.out.println(s1.equals(Season2.S1));


        // 枚举的嵌套
        System.out.println(NestedEnum.Gender.MALE);

    }
}
