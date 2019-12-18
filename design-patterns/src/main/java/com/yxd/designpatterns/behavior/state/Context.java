package com.yxd.designpatterns.behavior.state;

/**
 * @author yuxudong
 * @date 2019/11/8 9:16
 */
public class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request(String simpleParameter){
        // 调用 state 来处理
        state.handle(simpleParameter);
    }
}
