package com.jdk8.toa4.stream;

/**
 * Created by kobe on 2019/6/16.23:29
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class MatchDemo {
    public static void main(String[] args) {
        boolean b = Person.persons().stream()
                // 判断当前这个Person集合里面的 Person::isMale 是不是都是男。
                // allMatch() 判断流里面的元素，是不是都满足给定的条件。
                //.allMatch(Person::isMale)
                // 查看生日有没有 1990 年的。
                // anyMatch() 是不是存在这么一个元素。给条件就好。
                //.anyMatch(person -> person.getBirthDate().getYear()==1982)
                // 判断是不是没有人的工资是大于6000的？
                // noneMatch()
                .noneMatch(person -> person.getIncome() > 6000)
        ;
        System.out.println(b);
    }
}
