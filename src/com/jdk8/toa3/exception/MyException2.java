package com.jdk8.toa3.exception;

/**
 * Created by kobe on 2019/6/18.23:12
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class MyException2 extends Exception {
    // 和 MyEception 一样。
    public MyException2() {
        super();
    }

    public MyException2(String message) {
        super(message);
    }

    public MyException2(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException2(Throwable cause) {
        super(cause);
    }
}
