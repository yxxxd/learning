package com.yxd.designpatterns.struct.adapter;

/**
 * @author yuxudong
 * @date 2019/10/17 15:55
 * @description 类适配器
 *              通过调用Target接口中的request方法来实现Adaptee中的adapteeRequest方法
 */
public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void request() {
        // do something...
        super.adapteeRequest();
        // do something...
    }

    @Override
    public void response() {

    }
}
