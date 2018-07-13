package com.hdyl.android.pattern.layer.log;

/**
 * 状态模式与命令模式的结合 这个类包含着命令
 * @author  CH
 * Created by mac on 2018/7/10.
 */

public class Environment {


    private Order order;

    public Environment() {
        this.order = null;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
