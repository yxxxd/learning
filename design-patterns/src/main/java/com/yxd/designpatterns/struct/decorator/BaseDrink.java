package com.yxd.designpatterns.struct.decorator;

/**
 * @author yuxudong
 * @date 2019/10/18 11:36
 * @description 被装饰抽象类——基本饮料
 *  作用：当具体的被装饰类有多种时，抽象提出该抽象类，用于后面实现多态
 */
public abstract class BaseDrink {
    /**
     * 计算价格
     * @return 价格
     */
    public abstract int calculate();

    /**
     * 展示
     */
    public abstract void display();
}
