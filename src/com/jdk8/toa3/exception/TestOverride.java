package com.jdk8.toa3.exception;

/**
 * Created by kobe on 2019/6/19.19:17
 *
 * @author kobe
 * <br/>
 * Description:
 */
class Parent{
    public void m() throws MyException {

    }
}
class Son extends Parent{
    // 我们在方法重写时，不能抛出比父类更大的异常或者是更多的异常，只能和父类一样或者小于父类。
    @Override
    public void m() throws MyException{
    }
}
public class TestOverride {
}
