package com.yxd.designpatterns.struct.bridge;

/**
 * @author yuxudong
 * @date 2019/10/17 17:02
 * @description 桥接模式
 */
public class Main {
    public static void main(String[] args) {
        Shape square = new Square(new Black());
        square.draw();

        Shape circle = new Circle(new White());
        circle.draw();
    }
}
