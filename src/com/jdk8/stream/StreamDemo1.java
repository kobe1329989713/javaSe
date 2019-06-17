package com.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by kobe on 2019/6/16.20:43
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class StreamDemo1 {
    public static void main(String[] args) {
        /**
         首先通过一个数据源产生一个Stream，中间操作、终端操作。
         中间操作返回的都是Strea，所以可以一直调用其它方法。
         终端操作，获得结果
         */

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5,6);
        // 产生Stream
        // 偶数。
        Integer integer = nums.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(Integer::sum)
                .get();
        //.forEach(System.out::println);
        System.out.println(integer);
    }
}
