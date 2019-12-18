package com.yxd.designpatterns.struct.adapter;

/**
 * @author yuxudong
 * @date 2019/10/17 16:19
 * @description 缺省适配器模式：实现空的接口方法，让子类有选择的实现适配方法
 */
public abstract class AbstractTarget implements Target{
    @Override
    public void request() {}

    @Override
    public void response() {}
}
