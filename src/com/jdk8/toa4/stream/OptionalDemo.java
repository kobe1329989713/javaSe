package com.jdk8.toa4.stream;

import java.util.Optional;

/**
 * Created by kobe on 2019/6/16.21:42
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class OptionalDemo {
    public static void main(String[] args) {
        Person p = new Person(1, "kobe", 400, null, Person.Gender.MALE);
        // p 这个对象有一个 null 空，你想获取这个值时，就会报错空指针错误。
        //int year = p.getBirthDate().getYear();
        //System.out.println(year);

        // 这种情况就可以使用 Optional 这个类开处理。
        // of() 不能传 空。
        //Optional<String> kobe = Optional.of("Kobe");
        //Optional<String> kobe = Optional.of(null);
        // 它就可以
        //Optional<String> kobe = Optional.ofNullable("Kobe");
        Optional<String> kobe = Optional.ofNullable(null);
        if (kobe.isPresent()) {
            System.out.println(kobe.get());
        } else {
            System.out.println("null");
        }
        // 有值 取，没有用默认的。
        System.out.println(kobe.orElse("default"));

    }
}
