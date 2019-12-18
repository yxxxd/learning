package com.yxd.designpatterns.struct.facade;

/**
 * @author yuxudong
 * @date 2019/10/18 13:51
 * @description 子系统(SubSystem)角色
 */
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Square:draw()!");
    }
}
