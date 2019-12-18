package com.yxd.designpatterns.behavior.command;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuxudong
 * @date 2019/11/7 20:07
 * @description 命令调用类
 */
public class Broker {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        for (Order order : orderList) {
            order.execute();
        }
        orderList.clear();
    }
}
