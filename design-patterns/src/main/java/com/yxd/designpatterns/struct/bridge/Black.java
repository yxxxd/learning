package com.yxd.designpatterns.struct.bridge;

/**
 * @author yuxudong
 * @date 2019/10/17 16:56
 */
public class Black implements Color {
    @Override
    public void pain(String shape) {
        System.out.println("黑色的" + shape);
    }
}
