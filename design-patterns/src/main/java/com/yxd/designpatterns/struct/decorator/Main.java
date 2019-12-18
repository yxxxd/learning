package com.yxd.designpatterns.struct.decorator;

/**
 * @author yuxudong
 * @date 2019/10/18 11:47
 */
public class Main {

    public static void main(String[] args) {
        BaseDrink water = new Water();
        Decorator flesh = new FleshDecorator(water);
        Decorator sugar = new SugarDecorator(flesh);
        System.out.println(sugar.calculate());
        sugar.display();
    }


}
