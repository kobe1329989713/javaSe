package com.jdk8.io.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by kobe on 2019/6/17.1:30
 *
 * @author kobe
 * <br/>
 * Description:
 * 管道流。
 *
 * 写入一个马上就会读取一个。
 */
public class PipedStreamDemo {
    public static void main(String[] args) throws Exception {
        PipedInputStream pis = new PipedInputStream();
        // 这样做就相当于把他们关联在了一起了。
        //PipedOutputStream pos = new PipedOutputStream(pis);
        // 第二种做法。
        PipedOutputStream pos = new PipedOutputStream();
        pis.connect(pos);


        // 启动两个线程，分区处理输入流与输出流。
        new Thread(() -> produce(pos)).start();
        new Thread(() -> consume(pis)).start();
    }

    // 隔500毫秒，就把数据写入管道里。
    public static void produce(PipedOutputStream pos) {
        try {
            for (int i = 0; i < 50; i++) {
                pos.write(i);
                pos.flush();
                System.out.println("正在写入：" + i);
                Thread.sleep(500);
            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != pos) {
                    pos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // 有数据才读取，没有就阻塞在这里。
    public static void consume(PipedInputStream pis) {
        try {
            int num = -1;
            while ((num = pis.read()) != -1) {
                System.out.println("正在读取：" + num);
            }
            pis.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != pis) {
                    pis.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
