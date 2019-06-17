package com.jdk8.stream;

import java.util.Optional;

/**
 * Created by kobe on 2019/6/16.23:41
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class FindDemo {
    public static void main(String[] args) {
        //Optional<Person> any = Person.persons().stream()
        // 使用并行流。
        Optional<Person> any = Person.persons().parallelStream()
                .filter(Person::isFeMal)
                // 又变成了串行Stream 了。
                .sequential()
                // 从流中任意返回一个元素。或者从某个结果取
                .findAny()
        ;

        if (any.isPresent()) {
            Person p = any.get();
            System.out.println(p.getName());
        }
    }
}
