package com.yxd.designpatterns.behavior.observer;

/**
 * @author yuxudong
 * @date 2019/10/26 12:41
 * @description 观察者A
 */
public class ObserverA implements Observer {
    /**
     * 观察者状态
     */
    private String observerState;

    @Override
    public void update(String newState) {
        //更新观察者状态，让它与目标状态一致
        observerState = newState;
        System.out.println("接收到消息：" + newState + "；我是A模块，快来抢吧！！");
    }
}
