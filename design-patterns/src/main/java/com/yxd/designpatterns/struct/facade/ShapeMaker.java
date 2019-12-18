package com.yxd.designpatterns.struct.facade;

/**
 * @author yuxudong
 * @date 2019/10/18 13:52
 * @description 外观角色
 */
public class ShapeMaker {
    private Shape circle;
    private Shape rectangle;
    private Shape square;

    public ShapeMaker() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawAll() {
        circle.draw();
        rectangle.draw();
        square.draw();
    }
}
