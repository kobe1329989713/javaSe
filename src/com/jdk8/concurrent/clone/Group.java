package com.jdk8.concurrent.clone;

/**
 * Created by kobe on 2019/6/15.3:01
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class Group implements Cloneable{
    private String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

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
