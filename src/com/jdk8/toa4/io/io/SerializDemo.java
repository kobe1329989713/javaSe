package com.jdk8.toa4.io.io;

import java.io.*;

/**
 * Created by kobe on 2019/6/17.2:22
 *
 * @author kobe
 * <br/>
 * Description:
 * 创建对象除了，new，还有 反射、io序列化与反序列化、克隆、
 */
public class SerializDemo {
    public static void main(String[] args) {
        String p = "D:\\kobe\\idea\\ideaProjects\\space01\\javaSE01\\src\\com\\jdk8\\io\\test\\xx.kobe";
        //User user = new User(1, "Kk轠哇哈哈");
        try (
                //ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(p));
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(p))
        ) {

            // 把一个对象，写到一个文件当中去。序列化
            //oos.writeObject(user);

            // 在把它读出来。反序列化
            User u = (User) ois.readObject();
            System.out.println(u.getAge());
            System.out.println(u.getName());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
