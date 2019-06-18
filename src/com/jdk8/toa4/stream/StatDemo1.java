package com.jdk8.toa4.stream;

import java.util.DoubleSummaryStatistics;
import java.util.stream.Collectors;

/**
 * Created by kobe on 2019/6/16.23:06
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class StatDemo1 {
    public static void main(String[] args) {

        //double statistics = Person.persons().stream()
        DoubleSummaryStatistics statistics = Person.persons().stream()
                // 对 income 属性进行求和。
                //.collect(Collectors.summingDouble(Person::getIncome))
                // 某个属性的最大值与最小值。平均值，总和。得到一些统计信息。
                .collect(Collectors.summarizingDouble(Person::getIncome))
        ;
        System.out.println(statistics.getMax());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getSum());
    }
}
