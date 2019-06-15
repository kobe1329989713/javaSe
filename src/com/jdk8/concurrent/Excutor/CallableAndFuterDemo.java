package com.jdk8.concurrent.Excutor;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by kobe on 2019/6/14.17:28
 *
 * @author kobe
 * <br/>
 * Description:
 * callable 并发编程，的一个简单了解。
 */
public class CallableAndFuterDemo {
    public static void main(String[] args) throws Exception {

        Callable<Integer> c = new Callable<Integer>() {
            // 模拟的一个任务。
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 1;
            }
        };

        // 在把 callable 交给 future
        FutureTask<Integer> task = new FutureTask<>(c);
        // 获取结果。
        task.run();
        System.out.println(task.get());
        // 把 FutureTask 交给Executor 线程池去执行。

    }
}
