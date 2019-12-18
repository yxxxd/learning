package com.yxd.designpatterns.behavior.state;

/**
 * @author yuxudong
 * @date 2019/11/8 9:17
 */
public class ConcreteStateA implements State {
    @Override
    public void handle(String sampleParameter) {
        System.out.println("ConcreteStateA handle: " + sampleParameter);
    }
}
