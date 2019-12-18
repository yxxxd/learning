package com.yxd.designpatterns.behavior.command;

/**
 * <p>
 *     具体命令类
 * </p>
 * @author yuxudong
 * @date 2019/11/7 20:07
 */
public class SellStock implements Order {
    private Stock abcStock;

    public SellStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.sell();
    }
}
