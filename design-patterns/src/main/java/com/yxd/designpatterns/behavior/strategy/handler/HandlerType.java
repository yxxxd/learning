package com.yxd.designpatterns.behavior.strategy.handler;

import java.lang.annotation.*;

/**
 * @author yuxudong
 * @date 2019/11/8 9:40
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface HandlerType {
    String value();
}
