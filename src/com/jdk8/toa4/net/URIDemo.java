package com.jdk8.toa4.net;

import java.net.URI;

/**
 * Created by kobe on 2019/6/15.18:42
 *
 * @author kobe
 * <br/>
 * Description:
 * URI 是分 URL 和 URN
 * URL 是 URI 的一个子类。
 */
public class URIDemo {

    public static void main(String[] args) throws Exception {
        // 得到实例。
        // 根据它提供的方法，得到一些信息，看api 就能知道你能获取到那些信息。
        URI uri1 = new URI("https://www.baidu.com/s?wd=java%20RowSet%20%E5%BA%94%E7%94%A8%E5%9C%BA%E6%99%AF&rsv_spt=1&rsv_iqid=0x8a9c2a2d00070d28&issp=1&f=3&rsv_bp=1&rsv_idx=2&ie=utf-8&tn=baiduhome_pg&rsv_enter=1&rsv_sug3=1&rsv_sug1=1&rsv_sug7=001&rsv_sug2=0&rsp=3&rsv_sug9=es_2_1&inputT=1449&rsv_sug4=2981&rsv_sug=9");
        URI uri2 = URI.create("http://www.baidu.com");

        // schema 一般就代表 网络协议。
        System.out.println(uri1.getScheme());
        // 因为它是域名了，所以打印 百度。
        System.out.println(uri1.getHost());
        // 域名它是没有端口的，所以返回 -1
        System.out.println(uri1.getPort());

        // 就是得到 URL 后面传递的哪些参数， &&
        // 域名到 ？
        System.out.println(uri1.getPath());
        // url ? 后面哪些参数，它就能得到。查询字符串。
        System.out.println(uri1.getQuery());


        // 形成一个新的 URL
        URI uri3 = new URI("index.jsp");
        System.out.println(uri1.resolve(uri3));
    }
}
