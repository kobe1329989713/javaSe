package com.jdk8.toa4.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by kobe on 2019/6/16.23:17
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class GroupDemo {
    public static void main(String[] args) {
        //Map<Person.Gender, List<Person>> r = Person.persons().stream()
        Map<Boolean, List<Person>> r = Person.persons().stream()
                // 按照性别进行分组。
                //.collect(Collectors.groupingBy(Person::getGender));
                // 按照某个属性进行分区。
                .collect(Collectors.partitioningBy(Person::isMale));
        // 输出结果。
        r.forEach((g,ps)->{
            System.out.println(g);
            ps.forEach(System.out::println);
        });



    }
}
