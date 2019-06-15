package com.jdk8.jni;

/**
 * Created by kobe on 2019/6/15.2:06
 *
 * @author kobe
 * <br/>
 * Description:
 * java 调用c ,  c调用java。
 *
 *  头文件。在 cmd 下，用 javah  这个类的全路径。
 *  javah D:\kobe\idea\ideaProjects\space01\javaSE01\src\com\concurrent\jni\JNITest.java
 */
public class JNITest {

    // JNI ---> java 调用 c

    // 依赖。
    static {
        System.loadLibrary("jnitest");
    }

    public native void test();


    public static void main(String[] args) {
            new JNITest().test();
    }
}
