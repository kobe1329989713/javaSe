package com.jdk8.toa4.io.nio;

import java.nio.ByteBuffer;

/**
 * Created by kobe on 2019/6/17.5:28
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class BufferDemo {
    public static void main(String[] args) {
        // 10 是它的容量大小。这个缓冲里面 放 10 byte,
        // byte 的数据范围，-128 到 127，你放的 byte 不能超过这个范围。
        ByteBuffer b1 = ByteBuffer.allocate(10);
        ByteBuffer b2 = ByteBuffer.wrap(new byte[]{1,2,4});
        // allocateDirect() 这个方法是 ByteBuffer 特有的。
        // 它是一个固定大小的，后面不能修改了。 所以你能把它理解成一个数组就行。
        // allocateDirect() 它会在操作系统的内存中分派，allocate() 是在jvm中分派。
        ByteBuffer b3 = ByteBuffer.allocateDirect(10);


        // 这个数组的大小是10
        // 里面的元素，你没有赋值的时候，它也是10个元素，只不过是10个0
        byte[] b = new byte[10];


        // limit 就是 Buffer 中，有多少个元素的 ，个数（计数）
        int limit = b1.limit();
        // 添加元素。
        for (int i = 0; i < limit; i++) {
            // 它添加元素后，会把位置自增下。
            //b1.put((byte) i);
            // 带有索引的，它的位置是不会变的。
            b1.put(i,(byte) i);
        }




        // 如果传参，就是设置 limit
        // limit(5) ,如果你设置为5，那么后面五个元素将忽略不计。只剩下前面五个作为这个Buffer的元素。
        //int limit = b1.limit();
        System.out.println(limit);
        for (int i = 0; i < limit; i++) {
            // 每循环一次通过 get() 方法来获取 Buffer 里面的值。
            // b1.get() 就得到当前位置的元素。位置就是 position
            System.out.print(b1.position()+"：");
            // 这个 position不变化。get() 永远得到的是第一个。
            // get() 方法得到当前元素，并且把 position 自增一下。
            // get() 是使用相对位置。就是取当前位置，它取完，会把位置向后移一位。
            //System.out.println(b1.get());
            // 它是position没有变化，但是Buffer里面的数据还是获取到了，根据下标获取的。
            // get(i) 它使用的是绝对位置，这个i 必须是变化的。
            System.out.println(b1.get(i));
        }
    }
}
