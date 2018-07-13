package com.hdyl.android.pattern.layer.log;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 状态模式
 * Created by mac on 2018/7/10.
 */

public class LogInvoker {//日志打印者

    private List<Order> orderList=new ArrayList<>();//维护一个order列表

    private Environment environment;

    public void addOrder(Order order){
        orderList.add(order);
    }

    public void executeAllOrder(){

        if(environment==null){
            environment=new Environment();
        }

        for (Order item :orderList) {
            item.execute(environment);
        }
        orderList.clear();
    }

    public Environment getEnvironment() {
        return environment;
    }
}
