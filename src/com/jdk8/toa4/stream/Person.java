package com.jdk8.toa4.stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kobe on 2019/6/16.21:25
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class Person {
    private int id;
    private String name;
    private double income;
    private LocalDate birthDate;

    public enum Gender{
        MALE,FEMAEL
    }
    // 性别
    private Gender gender;


    public static List<Person> persons() {
        Person p1 = new Person(1, "张三", 2000, LocalDate.of(1982, 3, 1), Gender.MALE);
        Person p2 = new Person(2, "张三01", 2002, LocalDate.of(1983, 4, 2), Gender.MALE);
        Person p3 = new Person(3, "张三02", 2005, LocalDate.of(1987, 5, 5), Gender.FEMAEL);
        Person p4 = new Person(4, "张三04", 3004, LocalDate.of(2983, 8, 2), Gender.MALE);
        Person p5 = new Person(6, "张三05", 9002, LocalDate.of(3983, 8, 9), Gender.FEMAEL);
        return Arrays.asList(p1, p2, p3, p4, p5);
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", income=" + income +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                '}';
    }

    // 判断是不是女。
    public boolean isFeMal() {
        return this.gender == Gender.FEMAEL;
    }

    // 判断是不是男。
    public boolean isMale() {
        return this.gender == Gender.MALE;
    }

    public Person() { }

    public Person(int id, String name, double income, LocalDate birthDate, Gender gender) {
        this.id = id;
        this.name = name;
        this.income = income;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
