package com.jdk8.net.tcp;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by kobe on 2019/6/15.19:42
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class TCPClient {

    public static void main(String[] args) throws Exception {
        // 客户端要知道，往那个服务器 请求 数据。
        Socket socket = new Socket("localhost", 9000);
        OutputStream os = socket.getOutputStream();
        os.write("Hello11".getBytes());
        os.flush();
        os.close();
    }

}
