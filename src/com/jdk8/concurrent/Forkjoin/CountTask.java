package com.jdk8.concurrent.Forkjoin;

import java.util.concurrent.*;

/**
 * Created by kobe on 2019/6/14.17:57
 *
 * @author kobe
 * <br/>
 * Description:
 * Fork / Join 大任务拆成小任务，
 *
 * 需求：计算 1 ~ 1000 之间整数之和。
 */
public class CountTask extends RecursiveTask<Integer> {

    // 每50 之间当成一个子任务。
    private static final int RANGE = 50;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int result = 0;
        if (end - start <= RANGE) {
            // 小于50的直接处理了，不用在拆分成子任务了。
            for (int i = start; i <= end; i++) {
                result += i;
            }
        } else {
            // 折成子任务。折半拆分。
            // 找到中间值。
            int middle = (start + end) / 2;
            // 两个任务。
            // 它这里有递归味道，因为你这里拆分 它肯定还是大于50的
            // 它递归的来调用这个 compute() 方法。
            // 直接拆分成 能计算的。
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask((middle + 1), end);
            // 调用
            leftTask.fork();
            rightTask.fork();
            // 等待子任务完成。
            int leftresult = leftTask.join();
            int rightresult = rightTask.join();
            result = leftresult + rightresult;
        }
        return result;
    }


    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        CountTask task = new CountTask(1, 10000);
        Future<Integer> f = pool.submit(task);
        try {
            System.out.println(f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //pool.shutdown();
    }

}
