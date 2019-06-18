package com.jdk8.toa4.stream;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by kobe on 2019/6/16.20:55
 *
 * @author kobe
 * <br/>
 * Description:
 * 创建Stream
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("22", "o1", "kobe");

        // builder()它是一个泛型方法。
        // 注：它最后还要在调用一次build() 方法。
        Stream<String> s2 = Stream
                .<String>builder()
                .add("jack")
                .add("kobe")
                .add("mar")
                .build()
        ;


        // 产生 1 ~ 5 的Stream 。包左不包右。
        IntStream i1 = IntStream.range(1, 6);
        i1.forEach(System.out::println);

        System.out.println("==// 产生 1 ~ 6 的Stream 。包左又包右。");
        IntStream i2 = IntStream.rangeClosed(1, 6);
        i2.forEach(System.out::println);
        // 其它如 DoubleStream LongStream 都有这些方法。


        System.out.println("创建一个空的的 Stream");
        // 一个元素都没有。
        Stream<Object> s3 = Stream.empty();
        IntStream empty = IntStream.empty();

        System.out.println("通过函数创建Stream");
        // 它将是一个死循环。iterator 和 generate 它们都是产生无限个元素的流。
        Stream<Long> s4 = Stream.iterate(1L, n -> n + 1);
        // 只输出10元素。
        s4.limit(10).forEach(System.out::println);
        System.out.println("===generate() ===");
        Stream
                .generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
        // 其它 XxxStream 也是有类似的方法。


        System.out.println("==通过数组创建Stream");
        Arrays.stream(new int[]{1,2,3,4,5});
        Arrays.stream(new String[]{"",""});


        System.out.println("==一个字符串也能产生Stream");
        // 为什么是IntStream
        // 因为 字符串，是字符组成。字符是由字节组成。所以是一个IntStream
        "aaa bbb".chars().forEach(System.out::println);

        // 正则 来创建Stream
        Pattern.compile(",").splitAsStream("aab,ddd,33").forEach(System.out::println);


        // 就可以执行 中间操作，终端操作了。
    }
}
