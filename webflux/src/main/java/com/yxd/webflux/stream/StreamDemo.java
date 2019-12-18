package com.yxd.webflux.stream;

import java.util.stream.IntStream;

/**
 * @author yuxudong
 * @date 2019/11/10 9:27
 */
public class StreamDemo {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        // 使用stream内部迭代
        // map就是中间操作（返回stream的操作）
        // sum就是终止操作（返回结果）

        int sum = IntStream.of(nums).map(StreamDemo::doubleNum).sum();
        System.out.println("惰性求值就是种植没有调用的情况下，中间操作不会执行");
        System.out.println(sum);
    }

    public static int doubleNum(int i){
        System.out.println("执行了乘以2的操作");
        return i*2;
    }
}
