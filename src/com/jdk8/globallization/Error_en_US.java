package com.jdk8.globallization;

import java.util.ListResourceBundle;

/**
 * Created by kobe on 2019/6/15.22:41
 *
 * @author kobe
 * <br/>
 * Description:
 * 英文的。
 */
public class Error_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        // 这个 值 ，你可以不使用 字符串，所以说它更灵活的原因所在。
        return new Object[][]{
            {"name","Name"},
            {"password","Password"}
        };
    }

}
