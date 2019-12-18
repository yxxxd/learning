package com.yxd.webflux.stream;

import java.util.Random;
import java.util.stream.Stream;

/**
 * @author yuxudong
 * @date 2019/11/10 19:49
 */
public class StreamDemo3 {
    public static void main(String[] args) {
        String str = "hello world I am Stream";
        // 把字符串中长度大于2的单词长度输出
        Stream.of(str.split(" ")).filter(s->s.length()>2).map(String::length).forEach(System.out::println);

        // flatMap A->B属性（是个集合），最终得到所有A元素里面B元素属性集合
        // intStream/longStream并不是Stream的子类，所以需要调用boxed方法进行装箱
        Stream.of(str.split(" "))
                .flatMap(s->s.chars().boxed())
                .forEach(i->System.out.println((char)i.intValue()));

        // peek 一般用于debug，是个中间操作，和forEach是终止操作
        Stream.of(str.split(" ")).peek(System.out::println).forEach(System.out::println);

        // limit 主要用于无限流 限制流的数量
        new Random().ints().filter(i-> i>100&&i<10000).limit(10).forEach(System.out::println);
    }
}
