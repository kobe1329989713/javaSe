package com.jdk8.toa3.exception;

/**
 * Created by kobe on 2019/6/18.22:48
 *
 * @author kobe
 * <br/>
 * Description:
 * 自定义异常，类名必须以  Exception 结尾，如：XxxExcetpin
 *
 */
//           这里继承也可以是 RuntimeException 这样就可以想处理就处理不想处理就不处理。
public class MyException extends Exception {

    // 异常肯定是需要打印异常信息的。所以你重写构造方法来到达然后调用父类里面的东东。
    // 就可以把异常信息，给调用者，看了。


    // 它们只需往父类里面 传就行了。

    public MyException() {
    }

    // 只打印出错的信息
    public MyException(String message) {
        super(message);
    }

    // 只打印出错的原因。
    public MyException(Throwable cause) {
        super(cause);
    }

    /**
     你 捕获了 test() 抛出的 myException 异常。处理下，又抛出 MyException2 异常,
     把 MyException 作为，出现Myexception2 异常的原因。

     在自定义异常那里，可以传出现异常的原因，就是这么传递的。
     */

    // message打印出错的信息，和 cause出错的原因。
    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    // 这个构造是？
    //public MyException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    //    super(message, cause, enableSuppression, writableStackTrace);
    //}
}
