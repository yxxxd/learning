package com.yxd.webflux.lambda;

import java.text.DecimalFormat;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

/**
 * @author yuxudong
 * @date 2019/10/29 22:22
 */
public class FunctionDemo {
    private final int money;

    public FunctionDemo(int money){
        this.money = money;
    }

    /**
     * 使用Function可以无需实现和定义过多的接口
     * @param moneyFormat
     */
    public void printMoneyFormat(Function<Integer, String> moneyFormat){
        System.out.println("我的存款："+moneyFormat.apply(this.money));
    }

    public static void main(String[] args) {
        FunctionDemo fd = new FunctionDemo(9999);
        fd.printMoneyFormat(i->new DecimalFormat("#,###").format(i));

        // 函数的链式调用
        Function<Integer, String> moneyFormat = i->new DecimalFormat("#,###").format(i);
        fd.printMoneyFormat(moneyFormat.andThen(s->"人民币"+s));

        // 断言函数接口 断言i>0，返回boolean
        IntPredicate intPredicate = i->i>0;
        // 与上面等价
        Predicate<Integer> predicate = i -> i>0;
        System.out.println(predicate.test(-9));

        // 消费函数接口 该写法等价于 Consumer<String> consumer = s->System.out.println(s)
        Consumer<String> consumer = System.out::println;
        consumer.accept("被消费的数据");
    }
}
interface IMoneyFormat{
    String format(int i);
}