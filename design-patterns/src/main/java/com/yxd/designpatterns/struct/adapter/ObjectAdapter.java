package com.yxd.designpatterns.struct.adapter;

/**
 * @author yuxudong
 * @date 2019/10/17 16:00
 * @description 对象适配器
 *      对象适配器与类适配器的区别在于，类适配器通过继承来完成适配，对象适配器则通过关联实现
 */
public class ObjectAdapter implements Target{
    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void request() {
        // do something...
        adaptee.adapteeRequest();
        // do something...
    }

    @Override
    public void response() {

    }
}
