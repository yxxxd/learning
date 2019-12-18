package com.yxd.designpatterns.behavior.strategy;

/**
 * @author yuxudong
 * @date 2019/11/8 9:35
 */
public interface IOrderService {
    /**
     * 根据订单的不同类型做出不同的处理
     * @param orderDTO 订单实体
     * @return 返回结果
     */
    String handle(OrderDTO orderDTO);
}
