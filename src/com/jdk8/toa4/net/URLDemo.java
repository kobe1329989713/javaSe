package com.jdk8.toa4.net;

import java.net.URL;

/**
 * Created by kobe on 2019/6/15.18:58
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class URLDemo {

    public static void main(String[] args) throws Exception {
        // URI 可以转成 URL 的。toURL()
        URL url1 = new URL("http://www.baidu.com");
        System.out.println(url1.getHost());
        // 它的操作，就和 URI 是差不多的。
    }

}
