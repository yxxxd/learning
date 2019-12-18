package com.yxd.designpatterns.struct.bridge;

/**
 * @author yuxudong
 * @date 2019/10/17 17:01
 */
public class Circle extends Shape {
    public Circle(Color color){
        setColor(color);
    }
    @Override
    public void draw() {
     color.pain("圆形");
    }
}
