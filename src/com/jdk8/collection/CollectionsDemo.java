package com.jdk8.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by kobe on 2019/6/16.19:56
 *
 * @author kobe
 * <br/>
 * Description:
 * 集合的 工具类 Collections
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        // 这里只能使用包装类型，不能使用int
        List<Integer> nums = new ArrayList<>();
        nums.add(100);
        nums.add(40);
        nums.add(60);
        nums.add(70);
        nums.add(90);
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
        System.out.println("=================");
        for (Integer num : nums) {
            System.out.println(num);
        }
        System.out.println("=========");
        // 排序。默认升序，可以传自定义的排序规则。
        Collections.sort(nums);
        nums.forEach(System.out::println);

        System.out.println("// 十分查找。注：必须要先排序，才能在进行二分查找");
        System.out.println(Collections.binarySearch(nums,100));

        System.out.println("shuffle=====");
        Collections.shuffle(nums);
        nums.forEach(System.out::println);

        System.out.println("reverse ====");
        Collections.reverse(nums);
        nums.forEach(System.out::println);

        System.out.println("swap ===");
        Collections.swap(nums,1,4);
        nums.forEach(System.out::println);



        System.out.println("转换为 受检集合 ===");
        List nums2 = nums;
        nums2.add("sss");
        nums2.add(false);
        // 这种你在循环时，就会报错。
        // 这样，它就只能添加，Integer 类型的元素了。
        List<Integer> num3 = Collections.checkedList(nums, Integer.class);


        System.out.println("===单列集合，只有一个元素的集合。");
        List<String> name = Collections.singletonList("Tom");
        // 你在往这个集合里面添加元素时，就会报错了。
        //name.add("kobe");
    }
}
