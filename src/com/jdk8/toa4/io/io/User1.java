package com.jdk8.toa4.io.io;

import java.io.*;

/**
 * Created by kobe on 2019/6/17.2:18
 *
 * @author kobe
 * <br/>
 * Description:
 * java 序列化
 */
public class User1 implements Externalizable {


    private int age;
    private String name;

    // 在进行序列化，读 或者是 写 之前它会执行这两个方法。你就可以用它干一些事情了
    // 如：过滤掉一些，我不想序列化的属性，或者是 我不想读的一些属性。
    // 注：它们定的的属性的顺序必须要一致 才行。
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        // 把想要序列化的属性，写在这里就好。
        //out.writeInt(age);  // 我就不序列化 age 属性了。
        out.writeUTF(name);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        //age = in.readInt(); 我不想读 age 属性了。
        name = in.readUTF();
    }

    public User1(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
