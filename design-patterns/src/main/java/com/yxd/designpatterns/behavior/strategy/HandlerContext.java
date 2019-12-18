package com.yxd.designpatterns.behavior.strategy;

import com.yxd.designpatterns.behavior.strategy.handler.Handler;
import org.springframework.beans.BeanUtils;

import java.util.Map;

/**
 * @author yuxudong
 * @date 2019/11/8 9:38
 */
public class HandlerContext {
    private Map<String, Class> handlerMap;
    public HandlerContext (Map<String, Class> handlerMap){
        this.handlerMap = handlerMap;
    }
    public Handler getInstance(String type){
        Class clazz = handlerMap.get(type);
        if (clazz == null){
            throw new IllegalArgumentException("not fount handler for type: " + type);
        }
        return BeanUtils.instantiateClass(clazz, Handler.class);
    }
}
