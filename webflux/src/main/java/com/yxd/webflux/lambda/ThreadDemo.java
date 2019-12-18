package com.yxd.webflux.lambda;

/**
 * @author yuxudong
 * @date 2019/10/29 21:35
 * @descrpition 使用lambda表达式创建线程
 */
public class ThreadDemo {
    public static void main(String[] args) {
        // 方式1
        new Thread(()-> System.out.println("123")).start();

        // 方式2
        Runnable target = ()-> System.out.println("123");
        new Thread(target);

        Runnable target2 = ()-> System.out.println("123");
        //false
        System.out.println(target==target2);
    }
}
