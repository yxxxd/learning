package com.yxd.designpatterns.create.abstractfactory;

/**
 * @author yuxudong
 * @date 2019/10/16 17:22
 */
public abstract class AbstractFactory {
    abstract Juice createJuice();
    abstract Pie createPie();
}
