package com.yxd.designpatterns.behavior.state;

/**
 * <p>
 *                          状态模式
 *     State：抽象状态类，定义一个接口封装 context 的一个状态相关行为
 *     ConcreteState：具体状态类，每一子类实现一个与 Context 相关的行为
 *     Context：维护一个 ConcreteState 子类的实例，这个实例定义当前的状态
 * </p>
 * @author yuxudong
 * @date 2019/11/8 9:18
 */
public class Main {
    public static void main(String[] args) {
        // 创建状态
        State stateA = new ConcreteStateA();
        // 创建环境
        Context ctx = new Context();
        // 环境中设置状态
        ctx.setState(stateA);
        // 执行请求
        ctx.request("test");
    }
}
