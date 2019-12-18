package com.yxd.designpatterns.struct.decorator;

/**
 * @author yuxudong
 * @date 2019/10/18 11:37
 */
public class Water extends BaseDrink {
    @Override
    public int calculate() {
        return 2;
    }

    @Override
    public void display() {
        System.out.println("water");
    }
}
