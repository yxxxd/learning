package com.yxd.designpatterns.behavior.state;

/**
 * @author yuxudong
 * @date 2019/11/8 9:17
 */
public class ConcreteStateB implements State {
    @Override
    public void handle(String sampleParameter) {
        System.out.println("ConcreteStateB handle: " + sampleParameter);
    }
}
