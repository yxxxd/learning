package com.yxd.designpatterns.struct.adapter;

/**
 * @author yuxudong
 * @date 2019/10/17 16:21
 */
public class DefaultAdapter extends AbstractTarget {
    private Adaptee adaptee = new Adaptee();
    @Override
    public void response() {
        adaptee.adapteeRequest();
    }
}
