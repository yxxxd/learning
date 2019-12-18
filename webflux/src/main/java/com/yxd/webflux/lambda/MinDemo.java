package com.yxd.webflux.lambda;

import java.util.stream.IntStream;

/**
 * @author yuxudong
 * @date 2019/10/29 21:31
 */
public class MinDemo {
    public static void main(String[] args) {
        int[] num = {78,54,73,52,11,38,1,9,-4};
        System.out.println(IntStream.of(num).parallel().min().getAsInt());
    }
}
