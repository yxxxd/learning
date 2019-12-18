package com.yxd.designpatterns.create.abstractfactory.po;

import com.yxd.designpatterns.create.abstractfactory.Pie;

/**
 * @author yuxudong
 * @date 2019/10/16 22:49
 */
public class ApplePie implements Pie {
    @Override
    public void desc() {
        System.out.println("苹果派");
    }
}
