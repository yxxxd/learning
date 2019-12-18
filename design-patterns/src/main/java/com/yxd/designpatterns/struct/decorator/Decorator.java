package com.yxd.designpatterns.struct.decorator;

/**
 * @author yuxudong
 * @date 2019/10/18 11:40
 * @description 抽象装饰者类——Decorator
 *  要点：1.抽象装饰者类中继承该抽象类以保持接口规范
 *       2.包含该抽象类的引用以通过多态的方式对多种被装饰者类进行装饰。
 */
public abstract class Decorator extends BaseDrink {
    protected BaseDrink baseDrink;
    public Decorator(BaseDrink baseDrink){
        this.baseDrink = baseDrink;
    }

    @Override
    public int calculate() {
        return baseDrink.calculate();
    }

    @Override
    public void display() {
        baseDrink.display();
    }
}
