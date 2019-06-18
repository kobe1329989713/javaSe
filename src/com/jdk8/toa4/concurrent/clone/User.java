package com.jdk8.toa4.concurrent.clone;

/**
 * Created by kobe on 2019/6/15.2:31
 *
 * @author kobe
 * <br/>
 * Description:
 * 实现 这个 Cloneable 接口，代表它可以克隆。
 *
 *
 *
 *
 *
 */
public class User implements Cloneable {
    private int id;
    private String name;
    private Group group;


    @Override
    public Object clone() throws CloneNotSupportedException {
        // 深克隆。
        User user = (User) super.clone();
        Group g = (Group) group.clone();
        user.group = g;
        return user;



        // 浅克隆。
        //return super.clone();
    }

    public User() { }

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
