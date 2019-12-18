package com.yxd.webflux.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yuxudong
 * @date 2019/11/10 20:16
 */
public class StreamDemo4 {
    public static void main(String[] args) {
        String str = "hello world I am Stream";

        // 使用并行流
        str.chars().parallel().forEach(i-> System.out.print((char)i));
        System.out.println();

        // 使用 forEachOrdered 保证顺序
        str.chars().parallel().forEachOrdered(i-> System.out.print((char)i));
        System.out.println();

        // 收集到list
        List<String> list = Stream.of(str.split(" ")).collect(Collectors.toList());
        System.out.println(list);

        // 使用reduce拼接字符串
        Optional<String> letters = Stream.of(str.split(" ")).reduce((s1, s2) -> s1 + "|" + s2);
        System.out.println(letters.orElse(""));

        // 带初始化值的reduce
        String reduce = Stream.of(str.split(" ")).reduce("", (s1, s2) -> s1 + "|" + s2);
        System.out.println(letters.orElse(""));

        // 计算总长度
        Integer length = Stream.of(str.split(" ")).map(s->s.length()).reduce(0, (s1, s2)->s1+s2);
        System.out.println(length);

        Optional<String> maxString = Stream.of(str.split(" ")).max((s1, s2) -> s1.length()-s2.length());
        System.out.println(maxString.get());

        /////////////////////////////////////////////////////////////////////////////

        // 使用 findFirst  **短路操作**
        OptionalInt findFirst = new Random().ints().findFirst();
        System.out.println(findFirst.getAsInt());

    }
}
