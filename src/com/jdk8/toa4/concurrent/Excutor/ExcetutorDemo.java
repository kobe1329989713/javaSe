package com.jdk8.toa4.concurrent.Excutor;

import java.util.concurrent.*;

/**
 * Created by kobe on 2019/6/14.17:39
 *
 * @author kobe
 * <br/>
 * Description:
 * Exceutor 线程池。
 *
 *
 *         // Java获取可用处理器的数目
 *         int PROCESSORS = Runtime.getRuntime().availableProcessors();
 *         System.out.println("PROCESSORS: " + PROCESSORS);
 */
@SuppressWarnings("all")
public class ExcetutorDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建有五个线程的，一个线程池。
        // 就可以往这个线程池里面提交任务。
        ExecutorService es = Executors.newFixedThreadPool(5);
        // 提交任务。
        Future<Integer> future = es.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000);
                return 1;
            }
        });

        // 获取结果。
        System.out.println(future.get());
        //
        es.shutdown();
    }
}
