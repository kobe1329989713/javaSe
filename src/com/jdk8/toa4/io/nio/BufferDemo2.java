package com.jdk8.toa4.io.nio;

import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;

/**
 * Created by kobe on 2019/6/17.5:59
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class BufferDemo2 {
    public static void main(String[] args) {
        // 因为这个Buffer 分派了10个容量，它的limit 现在也是10，注：limit 是可以修改的。
        ByteBuffer b = ByteBuffer.allocate(10);
        // 设置为只读Buffer
        //b = b.asReadOnlyBuffer();

        // 复制Buffer
        //b.duplicate();

        for (int i = 0; i < b.limit(); i++) {
            b.put((byte) i);
        }
        b.position(3);
        System.out.println(b.get(3));
        // 分割Buffer，把Buffer 中，某一段，做什么操作，如共享，
        // 这一段的距离为 当前位置 到后面
        // 如果 原始Buffer数据发生改变了，那么这个分割的这个Buffer的数据也会跟着变化的。
        ByteBuffer b1 = b.slice();
        b.put(5, (byte) 100);
        while (b1.hasRemaining()) {
            System.out.println(b1.get());
        }
        System.out.println("=====================");


        // 把位置又变回0
        // 位置回到最初始状态了，但是数据已经添加进了Buffer里了。
        b.position(0);
        // 因为put() 每次添加元素后，会被位置自增下，所以打印是 10
        System.out.println("获取当前的位置（position）" + b.position());


        // 传了值，就是设置了上界，那么现在这个Buffer只能存放五个元素了。但是之前的数据还是在这个Buffer里的。
        // 但是你循环，它只打印前面五个元素，后面的它就忽略了。
        b.limit(5);
        for (int i = 0; i < b.limit(); i++) {
            System.out.println(b.get());
            // 我想在第三个元素做一个标记。这个标记是记在第三个元素这里不变的。其它的还是会变，如：位置
            if (i == 2) {
                b.mark();
            }
            // clear() 是回复到初始状态，不管你之前做了多少操作全部清0，
            // 位置为0、limit为容量的大小、mark 全部没有。
        }
        System.out.println(b.position());
        // 把位置设置到你刚做标记那里。
        // 你必须要先标记了，才能调用 reset() 方法，不然就会报错。
        b.reset();
        System.out.println(b.position());
        System.out.println(b.limit());
        // 设置上界到位置，而将位置设置为0
        b.flip();
        System.out.println(b.position());
        System.out.println(b.limit());


        // asXxxxBuffer()把一个Buffer 转换成另外一种类型的Buffer.
        //b.asDoubleBuffer();
        // 小的类型的Buffer 转大的类型的Buffer 是ok。反之则不行。


        // 如：这个DoubleBuffer 转换 字节Buffer 的方法都没有。
        DoubleBuffer b3 = DoubleBuffer.allocate(10);
    }
}
