package com.jdk8.net.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by kobe on 2019/6/15.19:58
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class UDPServer {

    public static void main(String[] args) throws Exception {
        // 这个进程一直在监听某个端口。只要往这个端口发数据，它就能监听到，并处理。
        DatagramSocket ds = new DatagramSocket(9000);
        while (true) {
            DatagramPacket dp = new DatagramPacket(new byte[1024], 1024);
            // 获取客户端发来数据。
            ds.receive(dp);
            byte[] data = dp.getData();
            int length = dp.getLength();
            int offset = dp.getOffset();
            String s = new String(data, offset, length);
            System.out.println(s);

            // 服务器响应客户端信息。
            ds.send(dp);
        }
    }

}
