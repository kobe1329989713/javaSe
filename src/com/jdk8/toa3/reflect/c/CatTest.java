package com.jdk8.toa3.reflect.c;

import java.lang.reflect.Array;

/**
 * Created by kobe on 2019/6/20.1:48
 *
 * @author kobe
 * <br/>
 * Description:
 * 通过反射，来操作数组。
 */
public class CatTest {
    public static void main(String[] args) {
        Class<Cat> c = Cat.class;
        // 用反射创建Cat数组。
        Cat[] cats = (Cat[]) Array.newInstance(Cat.class, 10);
        System.out.println(cats.length);
        // 判断它是不是数组。
        System.out.println(cats.getClass().isArray());
        // 得到数组的类型。
        System.out.println(cats.getClass().getComponentType().getName());

        // 给数组赋值。
        cats[0] = new Cat();


        //
        int[] nums = (int[]) Array.newInstance(int.class, 5);

        //System.out.println(new String[10]);



        // 创建多维数组。三行五列。
        int[][] nums2 = (int[][]) Array.newInstance(int.class, 3, 3);


        int[] nums3 = (int[]) Array.newInstance(int.class, 5);
        // 是引用类型的直接就 set() 方法，看api
        Array.setInt(nums3,0,10);
        Array.setInt(nums3,1,11);
        Array.setInt(nums3,2,12);
        Array.setInt(nums3,3,13);
        Array.setInt(nums3,4,14);
        //for (int i : nums3) {
        //    System.out.println(i);
        //}
        System.out.println("// 通过反射遍历。");
        for (int i = 0; i < nums3.length; i++) {
            System.out.println(Array.getInt(nums3, i));
        }



    }
}
