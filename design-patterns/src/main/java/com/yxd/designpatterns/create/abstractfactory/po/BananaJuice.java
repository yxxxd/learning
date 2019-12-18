package com.yxd.designpatterns.create.abstractfactory.po;

import com.yxd.designpatterns.create.abstractfactory.Juice;

/**
 * @author yuxudong
 * @date 2019/10/16 22:47
 */
public class BananaJuice implements Juice {
    @Override
    public void desc() {
        System.out.println("香蕉汁");
    }
}
