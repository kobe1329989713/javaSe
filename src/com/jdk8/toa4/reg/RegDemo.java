package com.jdk8.toa4.reg;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by kobe on 2019/6/16.0:10
 *
 * @author kobe
 * <br/>
 * Description:
 * 正则。
 */
public class RegDemo {
    public static void main(String[] args) {
        // 那个字符串，开关必须是 以 a 开头。然后中括号里面 任意一个就好。结尾必须是以 C 结尾的
        String reg = "a[def]c";
        // matches() 接收一个正则表达式，返回一个 boolean 值。
        // 验证 s 是否属于 reg 这个正则。
        //String s = "abc";
        //String s = "afc";
        //String s = "nafc";
        String s = "nafcp";
        System.out.println(s.matches(reg));

        // 匹配正则的，就把它替换成 #
        String s1 = "cdeabcadcbhafca".replaceAll(reg, "#");
        // 只替换第一个。
        String s2 = "cdeabcadcbhafca".replaceFirst(reg, "#");
        System.out.println(s1);
        System.out.println(s2);


        // Pattern 这个类把正则表达式，编译成一个特定格式。
        // 使 正则表达式 匹配更快，效率更高。
        Pattern p = Pattern.compile(reg);
        // Matcher 它主要用于匹配。
        Matcher m = p.matcher("cdeabcadcbhafca");
        // 看 是否 能匹配上。 你调用一次，它就找一次。它的位置是会变化的。
        //System.out.println(m.find());
        while (m.find()) {
            // 找到匹配上的位置。
            System.out.println(m.start() + "\t" + m.end());
        }
    }
}
