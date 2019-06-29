package com.jdk8.toa3.lambda;

import java.util.function.Consumer;

/**
 * Created by kobe on 2019/6/28.10:48
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class JumpDemo {
    public static void main(String[] args) {
        // 需要一个 整形数组，但是没有返回值，所以使用 Consumer 这个函数式接口。

        // 在lambda表达式中使用 continue 和 break。
        Consumer<int[]> c = ints -> {
            int count = 0;
            for (int id : ints) {
                // 是偶数。
                if (id % 2 == 0) {
                    System.out.println(id);
                    count++;
                    continue;
                }
                if (count == 3) {
                    break;
                }
            }
        };

        // 调用 Consumer 这个函数式接口 里面的方法，并传参。
        c.accept(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9,10});

       System.out.println("------------------------------------------");

        /**
         是在lambda表达式里面的循环，可以随便使用 continue 和 break
         如果是在循环里的 lambda表达式，是不能使用 continue 和 break 的。
         */
        for (int i = 0; i < 3; i++) {
            Consumer<Integer> c1=id->{
                System.out.println(id);
                if (id == 1) {
                    //break;
                    //break;
                }
            };
            c1.accept(1);
        }

    }
}
