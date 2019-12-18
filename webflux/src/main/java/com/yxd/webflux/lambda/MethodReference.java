package com.yxd.webflux.lambda;

import java.util.Objects;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * <p>
 *  方法引用是用来直接访问类或者实例的已经存在的方法或者构造方法。
 *  方法引用提供了一种引用而不执行方法的方式，它需要由兼容的函数式接口构成的目标类型上下文。
 *  计算时，方法引用会创建函数式接口的一个实例。
 * </p>
 * @author yuxudong
 * @date 2019/10/30 22:09
 *
 */
public class MethodReference {
    public static void main(String[] args) {
        // 以下两种方式等价
        Consumer<String> consumer = s->System.out.println(s);
        Consumer<String> consumer2 = System.out::println;

        Dog dog = new Dog();
        dog.eat(1);

        // 静态方式的方法引用
        Consumer<Dog> consumer3 = Dog::bark;
        consumer3.accept(dog);

        // 非静态方法，使用对象实例的方法引用
        Function<Integer, Integer> function = dog::eat;
        // 输入输出类型相同时可使用UnaryOperator 以下两种等价
        UnaryOperator<Integer> function2 = dog::eat;
        IntUnaryOperator function3 = dog::eat;

        System.out.println("还剩"+function.apply(3)+"斤狗粮");
        System.out.println("还剩"+function2.apply(3)+"斤狗粮");

        // 使用类名来方法引用 双参数一返回值
        // 由于JDK中的非静态方法默认传入一个this对象，因此我们可以用BiFunction传一个实例代替这个this
        BiFunction<Dog, Integer, Integer> binaryOperator = Dog::eat;
        binaryOperator.apply(dog, 2);

        // 构造函数的方法引用
        // supplier 提供者
        Supplier<Dog> supplier = Dog::new;
        supplier.get().eat(1);

        // 带参数的构造函数的方法引用
        Function<String, Dog> stringDogFunction = Dog::new;
        System.out.println("创建了对象：" + stringDogFunction.apply("旺财"));
    }
}
class Dog{
    private String name = "小白";
    private int food = 10;

    Dog(){

    }

    Dog(String name){
        this.name = name;
    }

    public static void bark(Dog dog){
        System.out.println(dog.name+"叫了");
    }

    /**
     * JDK会默认将this传入非静态方法，
     * @param num
     * @return
     */
    public int eat(Dog this, int num){
        System.out.println("吃了" + num + "斤狗粮");
        food-=num;
        return food;
    }

    @Override
    public String toString() {
        return this.name;
    }
}