package com.yxd.designpatterns.behavior.command;

/**
 * <p>
 *      命令模式
 *    将请求抽象化，把不同的请求封装成对象
 * </p>
 * @author yuxudong
 * @date 2019/11/7 20:09
 */
public class Main {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        BuyStock buyStockOrder = new BuyStock(abcStock);
        SellStock sellStockOrder = new SellStock(abcStock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
