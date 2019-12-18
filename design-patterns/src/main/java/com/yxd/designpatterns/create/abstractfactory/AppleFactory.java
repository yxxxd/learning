package com.yxd.designpatterns.create.abstractfactory;

import com.yxd.designpatterns.create.abstractfactory.po.AppleJuice;
import com.yxd.designpatterns.create.abstractfactory.po.ApplePie;

/**
 * @author yuxudong
 * @date 2019/10/16 22:53
 */
public class AppleFactory extends AbstractFactory {
    @Override
    Juice createJuice() {
        return new AppleJuice();
    }

    @Override
    Pie createPie() {
        return new ApplePie();
    }
}
