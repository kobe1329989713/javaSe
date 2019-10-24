package com.jdk8.toa3.generic;

import java.util.List;

/**
 * Created by kobe on 2019/10/22.13:51
 *
 * @author kobe
 * <br/>
 * Description:
 * <T> T表示返回值是一个泛型，传递啥 ，就返回啥类型的数据，
 *
 * 泛型通配符，在写方法那里、在调用那里。这两个地方。
 * ？extends xx 下界，？super xx 上界
 */
public class GenericTT<T> {

    /**
     * <T> T 可以传入任何类型的List
     * 参数T
     * 第一个 表示是泛型 ****
     * 第二个 表示返回的是T类型的数据
     * 第三个 限制参数类型为T
     *
     * @param data z
     * @return
     */
    private <T> T getListFirst(List<T> data) {
        if (data == null || data.size() == 0) {
            return null;
        }
        return data.get(0);
    }

    /**
     * 这个只能传递T类型的数据
     * 返回值 就是实例化传递的对象类型
     *
     * @param data
     * @return
     */
    private T getListFisrt(List<T> data) {
        if (data == null || data.size() == 0) {
            return null;
        }
        return data.get(0);
    }
}
