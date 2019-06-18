package com.jdk8.toa4.stream;

import java.util.stream.Collectors;

/**
 * Created by kobe on 2019/6/16.22:37
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class CollecDemo {
    public static void main(String[] args) {
        // 把它们 的name属性，取出来并且放在一个集合当中。
        //List<Object> nams = Person.persons().stream()
        //Set<Object> nams = Person.persons().stream()
        //long nams = Person.persons().stream()
        //Map<Integer,String> nams = Person.persons().stream()
        String nams = Person.persons().stream()
                // map() 后，这个流，就只包含 name属性的 流了。
                .map(Person::getName)
                // collect 收集， 打印，并调用其它方法引用 ，来达到需求。
                //.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
                // 这个更简单
                //.collect(Collectors.toList());
                // 放在 set() 集合里。
                //.collect(Collectors.toSet());
                // 放在 有序 set() 集合里。
                //.collect(Collectors.toCollection(TreeSet::new));
                // 计算出这个流里面有多少个元素。
                //.collect(Collectors.counting());
                // 收集到一个map() 里面去。
                //.collect(Collectors.toMap(Person::getId,Person::getName));
                // 把收集的数据按照指定分隔符，并接 成一个字符串。
                .collect(Collectors.joining("####"));
        System.out.println(nams);
    }
}
