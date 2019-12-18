package com.yxd.webflux.flux;

import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author yuxudong
 * @date 2019/11/12 19:20
 */
public class Test {
    public static void main(String[] args) {

        Flux.generate(sink->{
            // 通过next产生一个简单的值
            sink.next("Hello");
            // 结束该序列
            sink.complete();
        }).subscribe(System.out::println);

        final Random random = new Random();
        Flux.generate(ArrayList::new, (list, sink)->{
            int value = random.nextInt(100);
            list.add(value);
            sink.next(value);
            if (list.size() == 10){
                sink.complete();
            }
            return list;
        }).subscribe(System.out::println);

        Flux.create(sink -> {
            for (int i = 0; i < 10; i++) {
                sink.next(i);
            }
            sink.complete();
        }).subscribe(System.out::println);
    }
}
