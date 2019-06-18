package com.jdk8.toa4.iter;

import java.util.Iterator;

/**
 * Created by kobe on 2019/6/16.5:38
 * https://edu.51cto.com//center/course/lesson/index?id=47283
 *
 * @author kobe
 * <br/>
 * Description:
 */
class Student{
    String name;
    public Student(String name) {
        this.name = name;
    }
}

class Clazz implements Iterable<Student>{

    @Override
    public Iterator<Student> iterator() {
        return new Iterator<Student>() {

            int index = 0;

            @Override
            public boolean hasNext() {
                return index != students.length;
            }

            @Override
            public Student next() {
                return students[index++];
            }
        };
    }

    Student[] students;
    public Clazz(int num) {
        students = new Student[num];
    }

    int index = 0;
    public void add(Student s) {
        students[index++] = s;
    }
}

public class IterDemo {
    public static void main(String[] args) {
        // 这年班级只能有三个学生。
        Clazz c = new Clazz(3);
        Student s1 = new Student("s1");
        Student s2 = new Student("s2");
        Student s3 = new Student("s3");
        c.add(s1);
        c.add(s2);
        c.add(s3);

        //for (Student s : c.students) {
        //    System.out.println(s.name);
        //}
        for (Student s : c) {
            System.out.println(s.name);
        }
    }
}
