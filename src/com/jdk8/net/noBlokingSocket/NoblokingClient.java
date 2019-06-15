package com.jdk8.net.noBlokingSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by kobe on 2019/6/15.21:24
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class NoblokingClient {

    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9000;

        InetSocketAddress serverAddress = new InetSocketAddress(address, port);
        Selector selector = Selector.open();
        SocketChannel channel = SocketChannel.open();
        channel.configureBlocking(false);
        // 连接服务器。
        channel.connect(serverAddress);
        // 注册Selector，感兴趣的操作，就注册到 selector 里。
        channel.register(selector,
                  SelectionKey.OP_CONNECT |
                        SelectionKey.OP_READ |
                        SelectionKey.OP_WRITE
        );

        while (true) {
            if (selector.select() > 0) {
                // 表示完成状。
                boolean status = processReadySet(selector.selectedKeys());
                if (status) {
                    break;
                }
            }
        }
    }

    public static boolean processReadySet(Set<SelectionKey> keys) throws IOException {
        Iterator<SelectionKey> iterator = keys.iterator();
        SelectionKey key;
        while (iterator.hasNext()) {
            key = iterator.next();
            iterator.remove();
            if (key.isConnectable()) {
                processConnect(key);
            }
            if (key.isReadable()) {
                //processRead(key);
            }
            if (key.isWritable()) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                // 等待客户端输入一个字符串然后发送给服务器端
                processWrite(key,reader.readLine());
            }
        }
        return false;
    }

    // msg 是要发送给服务器的消息。
    public static void processWrite(SelectionKey key, String msg) throws IOException {
        SocketChannel c = (SocketChannel) key.channel();
        ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
        // 把客户端的消息，传递给了服务器端了。
        c.write(buffer);
    }

    public static String processRead() {
        return "";
    }

    public static boolean processConnect(SelectionKey key) {
        SocketChannel c = (SocketChannel) key.channel();
        try {
            // 如果这个连接还是挂起的。
            while (c.isConnectionPending()) {
                c.finishConnect();
            }
        } catch (IOException e) {
            key.cancel();
            e.printStackTrace();
            return false;
        }
        // 操作完成状。
        return true;
    }

}
