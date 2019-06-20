package com.jdk8.toa3.enum1;

/**
 * Created by kobe on 2019/6/20.3:38
 *
 * @author kobe
 * <br/>
 * Description:
 */
enum Gender{
    MALE,FEMALE;
}
public class NoEnum {

    // 枚举改进。
    public static String getGender1(Gender g) {
        return "";
    }

    public static String getGender(char c) {
        if (c == 'f') {
            return "女";
        } else if (c == 'm') {
            return "男";
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        // 你调用这个方法，只能传两个参数，其它的没有结果，可以抛自定义异常。
        // 枚举就是限制你只能传那些参数。
        //System.out.println(getGender('a'));
        // 枚举改进。
        System.out.println(getGender1(Gender.FEMALE));
        System.out.println(getGender1(Gender.MALE));
    }
}
