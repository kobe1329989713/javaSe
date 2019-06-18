package com.jdk8.toa4.net;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by kobe on 2019/6/15.19:10
 *
 * @author kobe
 * <br/>
 * Description:
 *给你一个URL, 你把这个URL 的资源获取到本地来。
 */
public class URLContentDemo {

    public static void main(String[] args) throws Exception {
        URL url = new URL("http://www.baidu.com");
        // 就把它变成了一个流了，就是java IO 的那些操作了。
        InputStream is = url.openStream();
        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        String s = null;
        while ((s = r.readLine()) != null) {
            System.out.println(s);
        }
        r.close();

        // URL 除了返回一个网页，还有可能它返回的是一个文件。文件就用字节流来操作。这个就是文件下载功能了

    }

    static void getContent1() throws Exception {
        URL url = new URL("http://www.baidu.com");
        // 看 这个 URL 返回的是什么类型，如：文本 ，二进制(流 或者 文件)
        Class[] c = {String.class, BufferedReader.class, InputStream.class};
        // 如果 getContent() 返回的是 数组里面的某个类型，怎么处理。
        Object o = url.getContent(c);
        if (o instanceof String) {

        } else if (o instanceof BufferedReader) {

        } else if (o instanceof InputStream) {

        } else {

        }
    }

    static void getContent2() throws Exception {
        URL url = new URL("http://www.baidu.com");
        URLConnection c = url.openConnection();
        InputStream is = c.getInputStream();

        // 设置成 true 你就就往服务器端写数据。
        c.setDoOutput(true);
        c.connect();
        // 就可以通过这个os 对象往服务器端写数据。
        // 就是一个 put 请求。
        OutputStream os = c.getOutputStream();
    }

}
