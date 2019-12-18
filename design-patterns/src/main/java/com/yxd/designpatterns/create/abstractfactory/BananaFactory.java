package com.yxd.designpatterns.create.abstractfactory;

import com.yxd.designpatterns.create.abstractfactory.po.BananaJuice;
import com.yxd.designpatterns.create.abstractfactory.po.BananaPie;

/**
 * @author yuxudong
 * @date 2019/10/16 22:52
 */
public class BananaFactory extends AbstractFactory {

    @Override
    Juice createJuice() {
        return new BananaJuice();
    }

    @Override
    Pie createPie() {
        return new BananaPie();
    }
}
