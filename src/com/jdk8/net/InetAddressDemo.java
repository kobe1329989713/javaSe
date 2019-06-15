package com.jdk8.net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * Created by kobe on 2019/6/15.18:20
 *
 * @author kobe
 * <br/>
 * Description:
 * java 操作 IP 的类。
 */
public class InetAddressDemo {

    public static void main(String[] args) throws Exception {
        InetAddress a1 = InetAddress.getLocalHost();
        // 各种虚拟机它会给你分派一个IP地址，你在局域网，它也会分派一个IP地址给你。
        // 看你需求使用那个IP地址。
        // 它获取到的是虚拟机分派给你的IP地址。
        System.out.println(a1.getHostAddress());

        // 得到所有的IP地址。
        // 虚拟机分派给你的。
        // 局域网分派给你的。
        // 就是无线网卡分派给你的IP地址。
        // IPV6 的IP地址。
        InetAddress[] a2 = InetAddress.getAllByName("kobe");
        for (InetAddress address : a2) {
            System.out.println(address.getHostAddress());
        }


        // 网络上主机的IP地址。应该就是公网IP地址。
        // 如；查看 百度的 IP地址。
        InetAddress a3 = InetAddress.getByName("www.baidu.com");
        System.out.println(a3.getHostAddress());
        // 用 getAllByName() 也能得到百度的所有IP地址。


        // socket = ip + port,   IP地址 加 端口号 就是 Socket
        InetSocketAddress a4 = new InetSocketAddress("kobe", 80);
        // 它里面有很多方法，得到很多东西。

    }

}
