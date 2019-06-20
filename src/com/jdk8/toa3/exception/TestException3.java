package com.jdk8.toa3.exception;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by kobe on 2019/6/19.19:24
 *
 * @author kobe
 * <br/>
 * Description:
 */
class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("close()...");
    }
}
public class TestException3 {

    public static void main(String[] args) {
        try (
                MyResource resource = new MyResource();
                MyResource resource1 = new MyResource()
        ) {
            // 继续其它操作。


        } catch (Exception e) {
            e.printStackTrace();
        }
        // 你就可以不用写 finally ,来调用关闭了。
        // 只要实现是实现了 AutoCloseable 接口的 类都是可以这样使用的。
    }


    public static void test() {

        try {
            FileInputStream f = new FileInputStream("");
            Class.forName("");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
