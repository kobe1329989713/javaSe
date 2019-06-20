package com.jdk8.toa3.generic;

/**
 * Created by kobe on 2019/6/19.19:43
 *
 * @author kobe
 * <br/>
 * Description:
 * 泛型。
 */
class Wrapper{
    private Object data;

    public Wrapper(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

public class genericeDemo {
    public static void main(String[] args) {
        Wrapper one = new Wrapper("one");
        Wrapper w2 = new Wrapper(new Integer(222));
        Wrapper w3 = new Wrapper(200);
        // 上面这样做虽然可以把，数据存储进去，但是你在取数据时，就会报类型转换异步。
        // 必须要进行强转类型才行，这样不好，
        // 在强转时，可能还会遇到到把 String 转换 int ，你在编译时，是不会报错的，只有你在运行时就报出来了。
        // 所以泛型就是解决这个问题的，让你存取数据的类型保持一样。
    }
}
