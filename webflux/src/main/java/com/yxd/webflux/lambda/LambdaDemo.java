package com.yxd.webflux.lambda;

/**
 * @author yuxudong
 * @date 2019/10/29 21:42
 */
public class LambdaDemo {
    public static void main(String[] args) {
        // 等价
        Interface1 interface1 = (i)->i*2;
        Interface1 interface2 = i->i*2;
        Interface1 interface3 = i->{
            System.out.println("-------");
            return i*2;
        };


    }
}

interface Interface1{
    int fun(int i);
}
