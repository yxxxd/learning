package com.yxd.webflux.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author yuxudong
 * @date 2019/11/10 17:17
 */
public class StreamDemo2 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // 从集合创建
        list.stream();
        list.parallelStream();

        // 从数组创建
        Arrays.stream(new int[]{2,4,5,6});

        // 创建一个数字流
        IntStream.of(1,4,5);
        IntStream.rangeClosed(1,10);

        // 使用random创建一个无限流
        new Random().ints().limit(10);

        // 自己产生流
        Random r = new Random();
        Stream.generate(()->r.nextInt()).limit(10);
    }
}
