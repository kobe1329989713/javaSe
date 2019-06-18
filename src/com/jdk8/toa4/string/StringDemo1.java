package com.jdk8.toa4.string;

/**



 */
public class StringDemo1 {

    /**
    转义字符：
     \n --> 换行
     \r --> 回车
     \t --> tab 键
     \" --> 转义符，如；直接输出 "" ,或者是上面三个


     CharSequence 来自 java.lang 是一个接口，表示字符值的一个可读序列。看它翻译的意思。Sequence 是序列的意思。
     它的子类有：String StringBuffer StringBuilder




     */
    public static void main(String[] args) {
//        String s = "\r";
        String s = "\r\"";

        System.out.println(s);
        System.out.println("abc".length());

        System.out.println("=== String 池(pool) =");

        // 一个字面量，它直接去字符常量池里面去找 abc 这个常量。没有它就创建在常量池里面
        // 它直接指向，字符常量池。
        String s1 = "abc";
        String s4 = "abc";
        String s5 = "a" + "bc"; // 在编译时就已经确定了，所以它指向的还是 abc
        // 它直接在堆里面创建一个地址，指向常量池里面abc 对象。如果没有创建它，然后在指向它。
        // 它指向堆，在通过堆，去指向字符常量池。
        String s2 = "abc";
        String s3 = "abc";
        // 所以它输出false
        System.out.println(s1 == s2); // false
        System.out.println(s1 == s4); // true
        System.out.println(s2 == s3); // false
        System.out.println(s1 == s5); // true



        // 而试题
        // 下面这个两个创建了，几个对象。三个。
        String str1 = "hello";
        String str2 = "hello";
        /**
         因为
         str1 它先在堆里面，创建一个 hello 对象，然后指向 字符常量池里面，但是字符常量池里面没有
         所以它又在字符常量池创建一个hello对象，所以 str1 创建了两个对象。

         str2 它 new 说明它也会在堆里面创建一个对象。然后指向字符常量池里面。但是现在字符常量池
         里面已经有 hello 这个对象了，所以它直接指向 字符常量池里 hello 对象就好。



         */

// 所有编译的常量字符串字面量都会加到String池中。
        final String s6 = "He";
        String s7 = "He";
        String s8 = s6 + "llo";
        String s9 = s7 = "llo";
        System.out.println("Hello" == s8); // true  因为 s6 已经确定了。
        System.out.println("Hello" == s9); // false  而 s7 是一个变量。

        /**
         s7 + "llo"  它不是编译时确定值的，它是运行时确定值的。

         */
        // intern() 先去字符常量池里找，没有就创建一个，并放入到字符常量池里去。
        System.out.println((s7 + "llo").intern() == "Hello"); // true
        // 所以 s7 + "llo"  ,它没有创建一个并放入。然后在比较，所以是true

    }

}
