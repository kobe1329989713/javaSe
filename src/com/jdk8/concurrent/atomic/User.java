package com.jdk8.concurrent.atomic;

/**
 * Created by kobe on 2019/6/14.15:21
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class User {
    private String name;
    public volatile int score;
    public volatile Group group;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
