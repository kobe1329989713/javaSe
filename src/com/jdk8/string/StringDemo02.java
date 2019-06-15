package com.jdk8.string;

/**


 String 常用方法

 charAt()
 isEmpty()
 indexOf()
 lastIndexOf()
 substring()
 trim()
 replace()
 startWith()
 endsWith()
 split()
 join()
 valueOf()
 compareTo()


 // Don't understand method
matches()
offsetByCodePoints
regionMatches
.....


 String 是不可变。它在堆里面分派空间，你在修改它时，它是从新分派空间在赋值给它。
 尤其是在做字符串拼接的时候，很消耗性能的。为了解决这个问题就出现了下面两个东东。

 可变
 StringBuffer 线程安全。性能低。
 StringBuilder 线程不安全，性能高。

 什么是线程安全了？？？？

 */
//SuppressWarnings 忽略编译器产生警告信息。
@SuppressWarnings("all")
public class StringDemo02 {
    public static void main(String[] args) {
        String s = "a1bcdef";
        System.out.println(s.charAt(0));

        // new String() 它会报一个空指针异常。
        System.out.println(s.equals(""));
        System.out.println(s.isEmpty());
        // new String() 这种它就判断不了。
        System.out.println(s == "");
        // 用这种。
        System.out.println("".equals(s));

        // indexOf() 根据指定的参数获取基位置。
        // -1 代表不存在，
        System.out.println(s.indexOf("a"));
        System.out.println(s.indexOf("a",0));
        // 传 int 类型是 c 它的一个字节码。如：c 是 99，其它和传String类型是一样的了。
        System.out.println(s.indexOf(99));
        //System.out.println(s.indexOf("r"));



        // valueOf()将指定的内容转换成String 类型。
        Integer valueOf1 = 22;
        String valueOf2 = "";
        System.out.println(valueOf2.valueOf(valueOf1));
        char[] chars = {'a', 'b', 'c'};
        String s1 = String.valueOf(chars, 0, (chars.length));
        System.out.println(s1);

        String join = valueOf2.join("@","a","b","c", "_join02");
        System.out.println(join);

        // substring()


        // 按照字典顺序比较。
        // 正数：比它大。
        // 0：相等。
        // 负数：比它小。
        System.out.println("abc".compareTo("bbc"));
    }
}
