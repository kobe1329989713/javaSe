package com.jdk8.concurrent.clone;

/**
 * Created by kobe on 2019/6/15.2:30
 *
 * @author kobe
 * <br/>
 * Description:
 * 浅克隆， 它是把引用复制一份给它。
 * 看：浅克隆定义。在有道笔记，的 javaSE03 并发编程。
 */
public class TestCloneUser {
    public static void main(String[] args) throws CloneNotSupportedException {
        User user1 = new User(1, "Tom");

        // 一个简单的，它是不能叫克隆的。
        //User user2 = user1;
        //User user2 = new User(user1.getId(), user1.getName());

        user1.setId(20);
        user1.setName("kobe");
        user1.setGroup(new Group("一组"));

        // user1 变，user2 也会跟着变化。
        // copy 一份副本，给 user2
        User user2 = (User) user1.clone();
        // **
        user1.setId(30);
        user1.setName("mar");
        // 浅克隆它就会跟着变。深克隆就不会。
        user1.getGroup().setName("二组");

        System.out.println(user2.getId() + "\t" + user2.getName() + "\t" + user2.getGroup().getName());

    }
}
