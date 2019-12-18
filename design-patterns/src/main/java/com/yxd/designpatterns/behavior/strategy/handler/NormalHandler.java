package com.yxd.designpatterns.behavior.strategy.handler;

import com.yxd.designpatterns.behavior.strategy.OrderDTO;

/**
 * @author yuxudong
 * @date 2019/11/8 9:45
 */
@HandlerType("1")
public class NormalHandler implements Handler {
    @Override
    public String handler(OrderDTO dto) {
        return "处理普通订单";
    }
}
