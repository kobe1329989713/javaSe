package com.jdk8.format;

import java.util.Locale;

/**
 * Created by kobe on 2019/6/16.3:50
 *
 * @author kobe
 * <br/>
 * Description:
 *  local 类 表示  语言环境。
 */
public class LocalDemo {
    public static void main(String[] args) {
        // 当前的语言环境，也可以获取其它的。
        Locale locale = Locale.getDefault();
        // 美国。
        //Locale locale = Locale.US;
        // 国家。国家代码。
        System.out.println(locale.getCountry());
        // 语言。 语言代码。
        System.out.println(locale.getLanguage());
        // 显示的国家。 显示就是 用你当前能看懂的语言 显示出来。
        System.out.println(locale.getDisplayCountry());
        // 显示的国家的语言。
        System.out.println(locale.getDisplayLanguage());
    }
}
