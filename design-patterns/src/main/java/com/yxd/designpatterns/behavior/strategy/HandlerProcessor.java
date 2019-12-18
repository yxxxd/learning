package com.yxd.designpatterns.behavior.strategy;

import com.yxd.designpatterns.behavior.strategy.handler.HandlerType;
import com.yxd.designpatterns.behavior.strategy.utils.ClassScaner;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yuxudong
 * @date 2019/11/8 9:48
 */
public class HandlerProcessor implements BeanFactoryPostProcessor {

    private static final String HANDLER_PACKAGE = "com.yxd.designpatterns.behavior.strategy.handler";
    /**
     * 扫描 @HandlerType，初始化HandlerContext，将其注册到Spring容器
     * @param beanFactory bean工厂
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        Map<String, Class> handlerMap = new HashMap<>(8);
        ClassScaner.scan(HANDLER_PACKAGE, HandlerType.class).forEach(clazz->{
            // 获取注解中的类型值
            String type = clazz.getAnnotation(HandlerType.class).value();
            // 将注解的类型值作为key，类作为value，存入map中
            handlerMap.put(type, clazz);
        });
        // 初始化HandlerContext， 将其注册到spring容器中
        HandlerContext ctx = new HandlerContext(handlerMap);
        beanFactory.registerSingleton(HandlerContext.class.getName(), ctx);
    }
}
