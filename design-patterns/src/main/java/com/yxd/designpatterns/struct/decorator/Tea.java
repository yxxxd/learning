package com.yxd.designpatterns.struct.decorator;

/**
 * @author yuxudong
 * @date 2019/10/18 11:38
 */
public class Tea extends BaseDrink {
    @Override
    public int calculate() {
        return 5;
    }

    @Override
    public void display() {
        System.out.println("tea");
    }
}
