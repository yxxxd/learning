package com.yxd.designpatterns.create.abstractfactory;

/**
 * @author yuxudong
 * @date 2019/10/16 22:53
 */
public class Main {
    public static void main(String[] args) {
        AbstractFactory factory1 = new BananaFactory();
        // 创建香蕉汁对象并调用方法
        factory1.createJuice().desc();
        // 创建香蕉派对象
        factory1.createPie().desc();

        AbstractFactory factory2 = new AppleFactory();
        factory2.createJuice().desc();
        factory2.createPie().desc();

    }
}
