package com.jdk8.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by kobe on 2019/6/16.19:43
 *
 * @author kobe
 * <br/>
 * Description:
 */
public class MapDemo {
    public static void main(String[] args) {
        // HashXxx 这种Hash开关的都是不能保证顺序的。
        Map<String, String> m1 = new HashMap<>();
        m1.put("a", "Acode");
        m1.put("b", "Bcode");
        m1.put("c", "Ccode");
        m1.put(null, "Ccode");
        m1.put(null, null);

        // 遍历
        Set<String> keys = m1.keySet();
        keys.forEach(key->{
            System.out.println(m1.get(key));
        });

        m1.values().forEach(v -> System.out.println(v));

        // 一个 key value  就是一个 entry
        Set<Map.Entry<String, String>> entries = m1.entrySet();
        entries.forEach(e -> System.out.println(e.getKey() + "\t" + e.getValue()));

        m1.forEach((k, v) -> System.out.println(k + "\t" + v));
    }
}
