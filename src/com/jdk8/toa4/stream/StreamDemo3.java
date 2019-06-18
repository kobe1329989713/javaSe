package com.jdk8.toa4.stream;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by kobe on 2019/6/16.21:56
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class StreamDemo3 {
    public static void main(String[] args) {
        Integer num = Stream.of(1, 2, 3, 4, 5)
                // peek() 你每次对流操作后，查看流中的元素是怎么的，类似输出查看结果。
                //.peek(n -> System.out.println("one" + n))
                //.peek(n -> System.out.println("two" + n))
                .filter(n -> n % 2 == 1)
                .reduce(0, Integer::sum);
        //System.out.println(num);


        Person.persons()
                .stream()
                // forEach() 里面可以使用lambda表达式和方法引用。
                //.forEach(person -> System.out.println(person))
                //.forEach(person -> System.out.println(person.getName()))
                // 它没有办法输出某一个属性。
                //.forEach(System.out::println)
        ;

        Person.persons()
                .stream()
                //  map() 映射 就只有 name了，其它属性都没有了。
                .map(Person::getName)
                // 这里它就可以输出某一个属性了，因为 map() 映射
                //.forEach(System.out::println)
        ;


        // 每个数的平方。
        IntStream.range(1, 5)
                .map(n -> n * n)
                //.forEach(System.out::println)
        ;


        Person.persons()
                .stream()
                // 只输出性别为男的。
                //.filter(Person::isMale)
                // 找出工资大于4000的
                .filter(p->p.getIncome()>4000)
                .map(Person::getName)
                //.forEach(System.out::println)
        ;


        // 去重。
        // 实例类 去重
        Stream.of(100,1,1,22,22,4,5,6)
                .distinct()
                // 限制输出多少。
                .limit(30)
                // 丢弃前面多少个
                .skip(2)
                // 排序，也可以自定义排序。
                .sorted()
                .forEach(System.out::println)
        ;


        // 经过中间一系列方法（）的操作后，reduce() 获取结果。
        // 要么把结果打印出来。
        // reduce() 有三种重载方式。
        Double sum = Person.persons()
                .stream()
                .map(Person::getIncome)
                // 0D 限制了它的类似，没有不写，它返回的是Optional<T> 这种类型的。
                .reduce(0D, Double::sum);
                //.reduce(Double::sum);
        //System.out.println("他们总工资为：" + sum);

        Optional<Double> sum2 = Person.persons()
                .stream()
                .map(Person::getIncome)
                .reduce(Double::sum);
        // Optional 最好要判断下。
        if (sum2.isPresent()) {
            System.out.println("他们总工资为：" + sum);
        }
    }
}
