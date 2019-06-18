package com.jdk8.toa3.exception;

import java.io.IOException;

/**
 * Created by kobe on 2019/6/18.21:20
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class ExceptionDemo1 {
    public static void main(String[] args) throws IOException {
        //int num1 = 10;
        //int num2 = 5;
        //int num2 = 0;
        //System.out.println(num1 / num2);
        // 遇到异常正常的代码都不能执行了，所以要把异常代码 try 起来。
        //System.out.println("hello");

        // 处理异常。
        int num1 = 10;
        int num2 = 0;
        try {
            // 放的是可能产生异常的代码。
            System.out.println(num1 / num2);
        } catch (Exception e) {
        //} catch (ArrayIndexOutOfBoundsException e) {  // 异常类型不匹配，也会中断你程序的运行。下面正常代码就不能输出了，因为中断程序了。
            // 处理异常。 没有异常 catch 里面的代码就不会被执行。
            System.err.println("异常的解决办法：零是不能做被除数的，你个瓜p");
            //e.printStackTrace();
            //System.out.println(e.getMessage());
        }finally {
            // 正常时，这里面的代码也会被执行。
            System.out.println("它里面的代码不管你有没有发生异常，它都会执行的。");
        }

        System.out.println("就算出现异常后面的正常代码，还是可以继续执行的。");





        // 异常也是一个对象。  e
        // catch(){} 那里的类型，只能是 Exception 或者是它的子类类型。
        // 异常类型不匹配，也会中断你程序的运行。


        System.out.println("===============");


        int n1 = 10, n2 = 5;
        int[] nums = {1, 2, 3};
        System.out.println(n1 / n2);
        try {
            System.out.println(nums[3]);
        }
        //catch (Exception e) {
        // 如果你把某个异常的最大父类，放在最前面，那么后面的匹配的那些异常是永远执行不到的，所以这里报错。
        // 所以一般 异常的处理 都是 从小到大 。？？
        //}
        catch (ArithmeticException e) {
            // 至少要把它打印，出来，你才知道在那里去找异常，才知道是那里出错了。
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            // 多重catch 处理，这样能精确的查找到异常，好进行处理
            // 当什么异常时，进入到对应的 catch 里面进行处理。
            // 查看 API 文档，来查看某个异常详细信息。
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("最顶级的异常 父类，要放在最后。");
        } finally {
            System.out.println("finally");
        }

        System.out.println("加try{}catch(){} 后面的正常代码，就可以正常执行。");


        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 抛出处理异常方式。
        // throws IOException ,谁调用 谁处理， 如果它在抛 就是虚拟机处理了。直接给你中止了(停止)。打印出来，自己慢慢去找吧。
        System.in.read();

    }

    // throw 它是一定有异常了，它也是可以用 try处理，或者抛出。
    public void m() throws IOException {
        throw new IOException();
    }


}
