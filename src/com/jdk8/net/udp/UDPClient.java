package com.jdk8.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by kobe on 2019/6/15.20:03
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class UDPClient {

    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        String msg = "hello 亚成";
        // 数据包
        DatagramPacket p = new DatagramPacket(msg.getBytes(), msg.getBytes().length);
        // 往哪个服务器发送数据。
        p.setAddress(InetAddress.getByName("localhost"));
        //
        p.setPort(9000);
        // 发送数据包。
        ds.send(p);


        // 客户端接收服务器响应的信息。
        ds.receive(p);
        byte[] data = p.getData();
        int length = p.getLength();
        int offset = p.getOffset();
        String s = new String(data, offset, length);
        System.out.println(s);
    }

}
