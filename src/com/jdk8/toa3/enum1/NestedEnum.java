package com.jdk8.toa3.enum1;

/**
 * Created by kobe on 2019/6/20.4:36
 *
 * @author kobe
 * <br/>
 * Description:
 * https://edu.51cto.com//center/course/lesson/index?id=45928
 */
public class NestedEnum {
    // 用了，
    enum Gender {
        MALE,FEMAL
    }

}
interface Interface1{
    void m();
}
enum Enum2 implements Interface1{
    a,b
    ; //这个分号，是不能删除的。

    @Override
    public void m() {

    }
}
