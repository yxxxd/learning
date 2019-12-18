package com.yxd.designpatterns.behavior.strategy.handler;

import com.yxd.designpatterns.behavior.strategy.OrderDTO;

/**
 * @author yuxudong
 * @date 2019/11/8 9:47
 */
@HandlerType("3")
public class PromotionHandler implements Handler {
    @Override
    public String handler(OrderDTO dto) {
        return "处理促销订单";
    }
}
