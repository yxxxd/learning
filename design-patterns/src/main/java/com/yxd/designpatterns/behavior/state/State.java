package com.yxd.designpatterns.behavior.state;

/**
 * @author yuxudong
 * @date 2019/11/8 9:14
 */
public interface State {
    /**
     * 状态对应的处理
     * @param sampleParameter
     */
    public void handle(String sampleParameter);
}
