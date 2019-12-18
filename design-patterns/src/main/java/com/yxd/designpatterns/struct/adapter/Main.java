package com.yxd.designpatterns.struct.adapter;

/**
 * @author yuxudong
 * @date 2019/10/17 16:03
 */
public class Main {
    public static void main(String[] args) {
        // 类适配器
        Target t = new ClassAdapter();
        t.request();

        // 对象适配器
        Target t2 = new ObjectAdapter(new Adaptee());
        t2.request();
    }
}
