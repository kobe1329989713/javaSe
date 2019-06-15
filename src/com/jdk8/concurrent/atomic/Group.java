package com.jdk8.concurrent.atomic;

/**
 * Created by kobe on 2019/6/14.16:35
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class Group {
    private String name;

    public Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
