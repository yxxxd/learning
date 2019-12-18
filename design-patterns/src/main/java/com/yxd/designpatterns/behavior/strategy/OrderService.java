package com.yxd.designpatterns.behavior.strategy;

import org.springframework.stereotype.Service;

/**
 * @author yuxudong
 * @date 2019/11/8 9:36
 */
@Service
public class OrderService implements IOrderService {


    @Override
    public String handle(OrderDTO orderDTO) {
        return null;
    }
}
