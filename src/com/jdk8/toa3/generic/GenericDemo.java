package com.jdk8.toa3.generic;

/**
 * Created by kobe on 2019/6/19.19:54
 *
 * @author kobe
 * <br/>
 * Description:
 */
class GenericWrapper<T, E> {
    private T data;

    public GenericWrapper(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

public class GenericDemo {
    public static void main(String[] args) {
        // T 是形参，传的值是 实参。
        // 泛型可以带多个
        GenericWrapper<String, String> s1 = new GenericWrapper<>("One");
        GenericWrapper<Integer, String> s2 = new GenericWrapper<>(22);
        GenericWrapper<Boolean, String> s3 = new GenericWrapper<>(true);
        System.out.println(s1.getData());
        System.out.println(s2.getData());
        System.out.println(s3.getData());

        // 泛型是不允许传 基本类型的，你也不需要传，它会自动帮你改成封装数据类型。
        //new GenericWrapper<int>(); // 直接这样传肯定是不行的。
        new GenericWrapper<Integer, String>(200); // 传包装数据类型就行了。
    }
}
