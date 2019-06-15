package com.jdk8.globallization;

import java.util.ListResourceBundle;

/**
 * Created by kobe on 2019/6/15.22:41
 *
 * @author kobe
 * <br/>
 * Description:
 * 中文的。
 */
public class Error_zh_CN extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{
            {"name","姓名"},
            {"password","密码"}
        };
    }

}
