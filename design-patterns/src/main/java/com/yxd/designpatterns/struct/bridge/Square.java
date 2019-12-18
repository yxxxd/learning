package com.yxd.designpatterns.struct.bridge;

/**
 * @author yuxudong
 * @date 2019/10/17 17:00
 */
public class Square extends Shape {
    public Square(Color color){
        setColor(color);
    }
    @Override
    public void draw() {
        color.pain("长方形");
    }
}
