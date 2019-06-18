package com.jdk8.toa4.net;

import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by kobe on 2019/6/15.19:02
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class URLEncodeDemo {

    public static void main(String[] args) throws Exception {
        // web 开发里面乱码，就是通过它来处理的。

        // URL 后面胡特殊字符，如：空格 点  % 这种就需要处理下，才能传递下后台服务器去。
        String p = "this is 2.5%";
        String encode = URLEncoder.encode(p, "UTF-8");
        System.out.println(encode);
        // 服务器在把它解码出来。
        System.out.println(URLDecoder.decode(encode,"UTF-8"));
    }

}
