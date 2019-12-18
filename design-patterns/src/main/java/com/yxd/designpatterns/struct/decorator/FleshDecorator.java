package com.yxd.designpatterns.struct.decorator;

/**
 * @author yuxudong
 * @date 2019/10/18 11:44
 * @description 装饰者类  果肉
 */
public class FleshDecorator extends Decorator {

    public FleshDecorator(BaseDrink baseDrink) {
        super(baseDrink);
    }

    @Override
    public int calculate() {
        return super.calculate() + 2;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("+ flesh");
    }
}
