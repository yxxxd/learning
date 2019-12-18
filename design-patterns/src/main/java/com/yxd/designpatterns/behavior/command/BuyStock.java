package com.yxd.designpatterns.behavior.command;

/**
 * @author yuxudong
 * @date 2019/11/7 20:06
 * @description 命令请求类
 */
public class BuyStock implements Order {
    private Stock abcStock;

    public BuyStock(Stock abcStock){
        this.abcStock = abcStock;
    }

    @Override
    public void execute() {
        abcStock.buy();
    }
}
