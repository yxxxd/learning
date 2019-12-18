package com.yxd.designpatterns.struct.bridge;

/**
 * @author yuxudong
 * @date 2019/10/17 16:57
 */
public abstract class Shape {
    protected Color color;
    public void setColor(Color color) {
        this.color = color;
    }
    public abstract void draw();
}
