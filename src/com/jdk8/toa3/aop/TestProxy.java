package com.jdk8.toa3.aop;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by kobe on 2019/6/20.3:13
 *
 * @author kobe
 * <br/>
 * Description:
 */
interface Fiying {
    void m1();

    int m2(int num);
}

class Swan implements Fiying {
    @Override
    public void m1() {
        System.out.println("m1");
    }

    @Override
    public int m2(int num) {
        System.out.println("m2");
        return 0;
    }
}

class LogInvocationHandler implements InvocationHandler {
    private Object targe;

    public LogInvocationHandler(Object targe) {
        this.targe = targe;
    }

    // proxy 代理实例，method 代理那个方法。args 这个方法参数，返回值是那个代理方法的返回值。
    // 在调用它 之前、之中、之后、出现异常。 二什么。
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("之前。。。。。");
        Object result = method.invoke(targe, args);
        System.out.println("。。。。。之后");
        return result;
    }
}

public class TestProxy {
    public static void main(String[] args) {
        // 目标类。
        Swan swan = new Swan();
        // 代理。
        Fiying b = (Fiying) Proxy.newProxyInstance(
                TestProxy.class.getClassLoader(),
                swan.getClass().getInterfaces(),
                new LogInvocationHandler(swan)
        );

        // 有了这个代理，你在调用 m1 m2 方法时，它就会在你调用方法之前干什么之后 干什么了。
        b.m1();
        System.out.println("-----------------------------");
        int i = b.m2(132);
        System.out.println(i);
    }
}
