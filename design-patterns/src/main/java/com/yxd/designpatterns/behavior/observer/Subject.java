package com.yxd.designpatterns.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuxudong
 * @date 2019/10/26 12:35
 * @description 被观察对象
 */
public class Subject {
    /**
     * 保存注册的观察者对象
     */
    private List<Observer> mObervers = new ArrayList<>();

    /**
     * 注册观察者对象
     */
    public void attach(Observer observer) {
        mObervers.add(observer);
        System.out.println("注册观察者对象");
    }

    /**
     * 注销观察者对象
     */
    public void detach(Observer observer) {
        mObervers.remove(observer);
        System.out.println("注销观察者对象");
    }

    /**
     * 通知所有注册的观察者对象
     */
    public void notifyEveryOne(String newState) {
        for (Observer observer : mObervers) {
            observer.update(newState);
        }
    }
}
