package com.yxd.webflux.lambda;

import java.util.function.Function;

/**
 * <p>
 *     级联表达式和柯里化
 *     柯里化：把多个参数的函数转换为只有一个参数的函数
 *     柯里化的目的：函数标准化
 *     高阶函数：返回函数的函数
 * </p>
 * @author yuxudong
 * @date 2019/11/9 20:50
 */
public class CurryDemo {
    public static void main(String[] args) {
        // 实现了x+y的级联表达式
        Function<Integer, Function<Integer, Integer>> function = x->y->x+y;
        System.out.println(function.apply(2).apply(3));

        Function<Integer, Function<Integer, Function<Integer, Integer>>> f = x->y->z->x+y+z;
        System.out.println(f.apply(2).apply(3).apply(4));
    }
}
