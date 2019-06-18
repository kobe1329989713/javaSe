package com.jdk8.toa4.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by kobe on 2019/6/16.16:57
 *
 * @author kobe
 * <br/>
 * Description:
 * 因为 List 是有序存储的，所以它也可以叫 序列sequence。
 */
class User{
    String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }
}
public class ListDemo {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        User u1 = new User("Tom");
        User u2 = new User("Tom");
        users.add(u1);
        users.add(u1);
        // 这个包含是一个 对象，这种包含了。
        //System.out.println(users.contains(u2));
        // 想让它包含，，你 User 类重写 equals() 方法就可以了。
        System.out.println(users.contains(u2));



        List<String> names = new ArrayList<>();
        //List<String> names = new LinkedList<>();
        // 索引必须按顺序来，可重复后面覆盖前面。
        names.add(0, "tom");
        names.add(0, "tom0");
        names.add(1, "tom1");
        names.add(2, "tom2");
        names.add(3, "tom3");
        //names.forEach(System.out::println);

        // 是否包含。
        System.out.println(names.contains("tom"));


        // 根据元素得到索引。
        //System.out.println(names.indexOf("tom"));
        //System.out.println(names.lastIndexOf("tom"));
        // 截取。包左，不包右。
        //names.subList(1,3).forEach(System.out::println);

        ListIterator<String> iter = names.listIterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
        System.out.println("=======倒着遍历=======");
        while (iter.hasPrevious()) {
            System.out.println(iter.previous());
        }
        // LinkedList  和 它差不多的用法。
        // 把 LinkedList api 熟悉下。
        //  LinkedList 它是链表。所以它增删 快。查询慢。
        // 它有 addFirst() addLast()  peek() poll() push()  它还实现了 Deque
        // 它修改 删除，只需要把引用改下就行。它查询比较慢。它顺时针找还是逆时针找。有对半在里面。

        // ArrayList 它查询快。
        // 数组的长度是不可变的，ArrayList 是如何动态的往里面增加元素的了？是如何做到数组长度自动增加的？
        // 因为ArrayList 低层用的是数组
        // ArrayList 也是可以给定一个容量。


    }
}
