package com.jdk8.io.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by kobe on 2019/6/17.0:59
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class OutputStreamDemo1 {
    public static void main(String[] args) {
        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\f1.txt";
        try (FileOutputStream fos = new FileOutputStream(p)) {
            fos.write("hello".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
