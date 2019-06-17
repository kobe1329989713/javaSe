package com.jdk8.collection;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by kobe on 2019/6/16.16:36
 *
 * @author kobe
 * <br/>
 * Description:
 *
 * Collection 是继承了 iterable 接口，所以所有集合都有 增强for 循环 for-each
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        ArrayList<String> c1 = new ArrayList<>();
        c1.add("a");
        c1.add("c");
        c1.add("b");
        c1.add("d");
        c1.add("f");

        Iterator<String> iter = c1.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
            // 你在调用remove() 之前，也必须要调用 next() 方法才行。
            // 因为它要进行 移动它才能找到下一个元素。
            //iter.remove();
        }
        System.out.println("size: "+c1.size());
        // for-each 它遍历，必须是从第一个元素到最后一个元素。
        // for-each 遍历，删除元素时会抛出异常。删除用 迭代器，来删除。
        for (String s : c1) {
            //c1.remove(s);
            System.out.println(s);
        }

        System.out.println("====================================");


        // forEach --> lambda
        c1.forEach(s-> System.out.println(s));

        // 传递方法引用。
        c1.forEach(System.out::println);
    }
}
