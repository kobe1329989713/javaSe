package com.jdk8.net.noBlokingSocket;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by kobe on 2019/6/15.20:43
 *
 * @author kobe
 * <br/>
 * Description:
 * 非阻塞的 socket  服务器与客户端 操作。
 */
public class NoBlokingServer {

    public static void main(String[] args) throws Exception {
        InetAddress address = InetAddress.getByName("localhost");
        int port = 9000;

        // 服务器端socket 通道。
        Selector selector = Selector.open();
        ServerSocketChannel server = ServerSocketChannel.open();
        // 配置为 非阻塞的。 因为它默认为 阻塞的。
        server.configureBlocking(false);
        // 它就会监听本机 9000 端口。
        server.bind(new InetSocketAddress(address, port));
        // 需要监听不同的事件，就需要register() 来注册选择器。
        // OP_ACCEPT 它表示有客户端请求到达服务器端了。
        server.register(selector, SelectionKey.OP_ACCEPT);

        // 不停的处理客户端请求。
        // select() 选择一个keys集合，这个key对应的通道准备进行 io 操作。
        while (true) {
            // 没有需要处理的 key
            if (selector.select() <= 0) {
                continue;
            }
            processReadySet(selector.selectedKeys());
        }
    }

    // 处理准备好的集合。
    public static void processReadySet(Set<SelectionKey> keys) throws IOException {
        Iterator<SelectionKey> iterator = keys.iterator();
        SelectionKey key;
        while (iterator.hasNext()) {
            key = iterator.next();
            iterator.remove();
            // 为true 说明有一个新的的请求来了，做处理。
            if (key.isAcceptable()) {
                processAccept(key);
            }
            // 为true 说明可以进行读操作了。
            if (key.isReadable()) {
                processRead(key);
            }
        }
    }

    public static void processRead(SelectionKey key) throws IOException {
        // 进行通信的 一个通道。
        SocketChannel c = (SocketChannel) key.channel();
        // 获取数据。
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        int byteCount = c.read(buffer);
        String msg = "";
        if (byteCount > 0) {
            buffer.flip();
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();
            CharBuffer charBuffer = decoder.decode(buffer);
            msg = charBuffer.toString();
            System.out.println(msg);
        }
    }


    public static void processAccept(SelectionKey key) throws IOException {
        // 看 ServerXxxChannel 说是一个服务器端通道。
        ServerSocketChannel sc = (ServerSocketChannel) key.channel();
        SocketChannel c = sc.accept();
        c.configureBlocking(false);
        c.register(key.selector(), SelectionKey.OP_READ);
    }


}
