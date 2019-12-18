package com.yxd.designpatterns.struct.facade;

/**
 * @author yuxudong
 * @date 2019/10/18 13:52
 * @description 外观模式
 *      外观模式通过为多个复杂的子系统提供一个一致的接口，而使这些子系统更加容易被访问的模式。
 *    该模式对外有一个统一接口，外部应用程序不用关心内部子系统的具体的细节，
 *    这样会大大降低应用程序的复杂度，提高了程序的可维护性。
 */
public class Main {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();

        shapeMaker.drawAll();
    }
}
