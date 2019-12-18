package com.yxd.webflux.lambda;

/**
 * @author yuxudong
 * @date 2019/11/9 19:53
 */
@FunctionalInterface
interface IMath{
    int add(int x, int y);
}
public class TypeDemo {


    public static void main(String[] args) {
        // 变量类型定义
        IMath lambda = (x,y)->x+y;
        // 数组里
        IMath[] lambda2 = {((x, y) -> x+y)};
        // 强转
        Object lambda3 = (IMath)(x, y)->x+y;
        // 通过返回类型
        IMath lambda4 = createLambda();
    }
    public static IMath createLambda(){
        return ((x, y) -> x+y);
    }


}
