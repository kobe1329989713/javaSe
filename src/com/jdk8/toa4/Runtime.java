package com.jdk8.toa4;

/**
 * Created by kobe on 2019/6/15.3:53
 *
 * @author kobe
 * <br/>
 * Description:
 * Runtime类获取java 环境类的一些信息。
 */
public class Runtime {
    public static void main(String[] args) throws Exception {
        java.lang.Runtime r = java.lang.Runtime.getRuntime();
        System.out.println(r.maxMemory());
        System.out.println(r.totalMemory());
        System.out.println(r.freeMemory());
        System.out.println(r.availableProcessors());
        r.gc();

        // 打系统记事本。
        r.exec("notepad").waitFor();
    }
}
