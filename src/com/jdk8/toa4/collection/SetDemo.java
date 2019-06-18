package com.jdk8.toa4.collection;

import java.util.*;

/**
 * Created by kobe on 2019/6/16.17:21
 *
 * @author kobe
 * <br/>
 * Description:
 */
class Dept implements Comparable<Dept>{
    String name;

    public Dept(String name) {
        this.name = name;
    }

    @Override
    public int compareTo(Dept o) {
        return name.compareTo(o.name);
    }

    @Override
    public boolean equals(Object obj) {
        // 如果类型一样。在比较它的值是否一样。
        if (obj instanceof Dept) {
            return name.equals(((Dept) obj).name);
        }
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
public class SetDemo {
    public static void main(String[] args) {
        // 要求对顺序有要求，就不能使用HashSet()了。
        Set<String> name = new HashSet<>();
        name.add("Tom");
        name.add("Jack");
        name.add("Rose");
        name.forEach(System.out::println);

        Set<Dept> depts = new HashSet<>();
        Dept d1 = new Dept("部门1");
        Dept d2 = new Dept("部门1");
        depts.add(d1);
        depts.add(d2);
        // 它就把两个“部门1”加入到了 HashSet() 里面了，只不过它是两个对象，所以能够加入进去。
        depts.forEach(dept -> System.out.println(dept.name));
        // 要想不加入进去，重写它的 equals() 和 haseCode() 方法就好。


        System.out.println("===// 要想 Set() 集合有序。就用 LinkedHashSet()===");
        LinkedHashSet<String> name2 = new LinkedHashSet<>();
        name2.add("Tom");
        name2.add("Jack");
        name2.add("Rose");
        name2.add("11");
        name2.add("22");
        name2.add("33");
        name2.add("44");
        name2.add("55");
        name2.forEach(System.out::println);


        System.out.println("=========TreeSet==================");
        // 排序，按照字母、数字、和 自定义排序。
        TreeSet<String> name3 = new TreeSet<>();
        name3.add("Aom");
        name3.add("Back");
        name3.add("Cose");
        name3.add("11");
        name3.add("22");
        name3.add("33");
        name3.add("44");
        name3.add("55");
        name3.forEach(System.out::println);

        System.out.println("===================");

        // 是类，就按照 类实现排序接口，重写排序方法里面的规则进行排序，也叫自定义排序吧。
        Dept d3 = new Dept("dept13");
        Dept d4 = new Dept("dept12");
        Dept d5 = new Dept("dept10");
        Set<Dept> depts2 = new TreeSet<>(new MyDeptComparator());
        depts2.add(d3);
        depts2.add(d4);
        depts2.add(d5);
        depts2.forEach(dept -> System.out.println(dept.name));
    }

    // 使用 comparator 的比较规则。
    // 需要自己定义排序逻辑，应用 comparator 来做。
    static class MyDeptComparator implements Comparator<Dept> {
        @Override
        public int compare(Dept o1, Dept o2) {
            //return o1.name.compareTo(o2.name);
            // 负号 降序。
            return -o1.name.compareTo(o2.name);
        }
    }

}
