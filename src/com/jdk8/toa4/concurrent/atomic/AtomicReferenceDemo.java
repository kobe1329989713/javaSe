package com.jdk8.toa4.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * Created by kobe on 2019/6/14.16:20
 *
 * @author kobe
 * <br/>
 * Description:
 * 引用类型，原子操作。
 */
public class AtomicReferenceDemo {
    public static void main(String[] args) {
        User user = new User();
        user.setName("kobe");
        user.setScore(100);
        AtomicReference<User> r1 = new AtomicReference<>();
        // 现在这个 user 类就是原子操作的了。
        r1.set(user);


        r1.getAndUpdate(u -> {
                    u.setScore(300);
                    return u;
                }
        );

        System.out.println(user.getScore());


        User user1 = new User();
        user1.setName("kobe");
        user1.setScore(200);
        r1.accumulateAndGet(user1,(u1,u2)->{
           u1.setScore(u2.getScore());
            return u1;
        });
        System.out.println(user.getScore());


        AtomicReferenceArray<User> r2 =
                new AtomicReferenceArray<>(new User[]{user, user1});
        // 也是只需要加上数组的索引，就可以对数组当中元素进行操作。
        r2.accumulateAndGet(0,user1,(u1,u2)->{
            u1.setScore(u2.getScore() * 2);
            return u1;
        });
        System.out.println(user.getScore());


        // 引用类型属性。原子操作。
        AtomicReferenceFieldUpdater<User, Group> r3 =
                AtomicReferenceFieldUpdater.newUpdater(User.class, Group.class, "group");
        User user3 = new User();
        user3.setName("kobe03");
        user3.setScore(100);
        Group group = new Group("一组");
        // **
        r3.set(user3,group);
        System.out.println(r3.get(user3).getName());
        // 先获取到 user3 里面的 group ,再对其进行修改。
        r3.getAndUpdate(user3,g->{
            g.setName("二组");
            return g;
        });
        // 获取。
        System.out.println(r3.get(user3).getName());
        System.out.println(user3.group.getName());

    }
}
