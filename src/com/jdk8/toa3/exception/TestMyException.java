package com.jdk8.toa3.exception;

/**
 * Created by kobe on 2019/6/18.22:49
 * https://edu.51cto.com//center/course/lesson/index?id=45907
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class TestMyException {

    public static void test(int num) throws MyException {
        // num 小于10抛出 我自定义的异常。
        // 自定义异常，一般都是拿给你抛出的。因为这种情况需要调用者来处理。最好。
        if (num < 10) {
            // 这里就是 构造赋值而已。 它有构造重载。
            // 看自定义异常那里。
            throw new MyException("库存不够了。");
        }
    }

    public static void main(String[] args) {
        // 调用者 处理自定义异常。
        try {
            test(2);
        } catch (MyException e) {
            e.printStackTrace();
        }

    }


}
