package com.yxd.designpatterns.struct.decorator;

/**
 * @author yuxudong
 * @date 2019/10/18 11:46
 */
public class SugarDecorator extends Decorator {
    public SugarDecorator(BaseDrink baseDrink) {
        super(baseDrink);
    }

    @Override
    public int calculate() {
        return super.calculate() + 1;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("+ sugar");
    }
}
