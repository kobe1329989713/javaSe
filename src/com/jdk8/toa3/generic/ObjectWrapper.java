package com.jdk8.toa3.generic;

/**
 * Created by kobe on 2019/6/19.21:58
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class ObjectWrapper<T> {
    private T data;

    public ObjectWrapper() {
    }

    public ObjectWrapper(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
