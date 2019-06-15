package com.jdk8.net.tcp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kobe on 2019/6/15.19:33
 *
 * @author kobe
 * <br/>
 * Description:
 * tcp 服务器 与 客户端 操作。
 */
public class TCPServer {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(9000);
        while (true) {
            // 监听客户端请求。
            // 它会阻塞在这里，等待客户端发来请求。
            // 有请求来时，它就开始处理请求。
            Socket socketed = server.accept();
            // 它就能接收到客户端发来消息了。
            InputStream is = socketed.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String msg = null;
            while ((msg = reader.readLine()) != null) {
                System.out.println(msg);
            }
            socketed.close();
        }

        /**
         这个服务器不应该接收客户端一次请求就停止了，要一直监听着。
         这个服务器不能响应信息给客户端。
         如果一个请求的处理需要很多时间来处理，这里服务器就不能接收新的请求了，这是不好的。
         所以一个请求由一个线程来处理。
         */
    }

}
