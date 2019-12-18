package com.yxd.designpatterns.behavior.strategy.handler;

import com.yxd.designpatterns.behavior.strategy.OrderDTO;

/**
 * @author yuxudong
 * @date 2019/11/8 9:44
 */
public interface Handler {
    String handler(OrderDTO dto);
}
