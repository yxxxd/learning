## 函数式编程
#### 函数接口
接口中有且只能有一个要实现的方法

在接口上加`@FunctionalInterface`注解，能够规范函数接口，若接口中有多个或没有方法（非`default`方法）则会报错

接口 | 输入参数 | 返回类型 | 说明
-----|---|---|---
`Predicate<T>` | T | boolean | 断言
`Consumer<T>` | T | / | 消费一个数据
`Function<T,R>` | T | R | 输入T，输出R的函数
`Supplier<T>` | / | T | 提供一个数据
`UnaryOperator<T>` | T | T |  一元函数，输入输出类型相同
`BiFunction<T,U,R>` | (T,U) | R | 2个输入的函数
`BinaryOperator<T>` | (T,T) | T | 二元函数，输入输出类型相同