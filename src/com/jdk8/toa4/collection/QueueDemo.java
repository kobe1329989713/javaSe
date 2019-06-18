package com.jdk8.toa4.collection;

import java.util.*;

/**
 * Created by kobe on 2019/6/16.18:53
 *
 * @author kobe
 * <br/>
 * Description:
 * 队列。
 */

class Person implements Comparable<Person>{
    String anme;

    @Override
    public int compareTo(Person o) {
        return anme.compareTo(o.anme);
    }

    public Person(String anme) {
        this.anme = anme;
    }

    public String getAnme() {
        return anme;
    }

    public void setAnme(String anme) {
        this.anme = anme;
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        // 简单队列。
        Queue<String> s1 = new LinkedList<>();
        s1.add("a");
        s1.add("b");
        s1.add("c");
        // offer() 和 add() 是一样的都是添加元素。如果是些固定长度的队列，当队列的满了，你在使用add() 往
        // 里面添加元素，它会抛出异常。而 offer() 就不会。它会返回一个 false 对于有容量的队列优先使用 offer()方法 添加元素。
        s1.offer("d");
        System.out.println(s1);

        // 队列是先进先出。所以它遍历出来的，和你加入进去的顺序是一样的。就是有序的，所以 List 用的也是它。
        // peek() 从队列的头部取出元素。
        while (s1.peek() != null) {
            //System.out.println(s1.peek());
            // element() 和 peek() 一样也是获取元素，
            System.out.println(s1.element());
            // 得到之后在移除掉。因为这里是循环，如果你不移除它，它一直打印的是 a
            // 只有把它移除之后，它才会找下一个元素。
            // 这样才能把集合的元素全部遍历出来。
            //s1.remove();

            // poll() 也是移除元素。如果它没有获取到元素，会返回一个空。不会抛出异常样。
            s1.poll();
            System.out.println(s1);
        }

        /**

         add() element()  remove() 它们在有边界的队列时，会报错
         offer() peek()  poll() 它们就不会。

         */


        System.out.println("=====//  优先队列。===");
        // 如果使用自己的类，出现类型转换错误，这种你的那个类必须要实现 comparable 比较接口。
        // 因为队列它肯定要有一个排序规则在里面的，它才能实现队列的功能。
        Queue<Person> s2 = new PriorityQueue<>();
        Person p1 = new Person("Tom");
        Person p2 = new Person("Jack");
        Person p3 = new Person("Rose");
        s2.add(p1);
        s2.add(p2);
        s2.add(p3);
        System.out.println(s2);

        while (s2.peek() != null) {
            // 谁先出列队，就和谁比较大，那么说明它的优先级比较高。
            // 就是你定义的排序规则，来的。 哪个排序规则就是它的优先级。
            // 也可以使用 Comparator
            Person p = s2.peek();
            System.out.println(p.anme);
            s2.remove();
        }


        System.out.println("===使用 Comparator 来定义你的排序（优先级）======");
        // 上面哪个 Person 类 就可以不用实现任何接口了，上面那个就可以去掉的。
        Queue<Person> s3 = new PriorityQueue<>(
                Comparator.comparing(Person::getAnme)
        );
        s3.add(p1);
        s3.add(p2);
        s3.add(p3);
        while (s3.peek() != null) {
            // 谁先出列队，就和谁比较大，那么说明它的优先级比较高。
            // 就是你定义的排序规则，来的。 哪个排序规则就是它的优先级。
            // 也可以使用 Comparator
            Person p = s3.peek();
            System.out.println(p.anme);
            s3.remove();
        }


        System.out.println("=====双端队列============");
        Deque<String> s4 = new LinkedList<>();
        // 它可以头部加尾部加，也可以头部取尾部取


        // 容器就是要往里面进行添加元素，然后在把它找出来。
        // 然后还有一些并发容器。
    }
}
