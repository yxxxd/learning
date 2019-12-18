package com.yxd.designpatterns.create.abstractfactory.po;

import com.yxd.designpatterns.create.abstractfactory.Pie;

/**
 * @author yuxudong
 * @date 2019/10/16 22:49
 */
public class BananaPie implements Pie {
    @Override
    public void desc() {
        System.out.println("香蕉派");
    }
}
