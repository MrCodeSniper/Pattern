package com.hdyl.android.pattern.layer.log;

import java.util.ArrayList;
import java.util.List;

/**
 * 状态模式 日志打印者
 * @author  ch
 * Created by mac on 2018/7/10.
 */
public class LogInvoker {

    /**
     * //维护一个order列表
     */
    private List<Order> orderList=new ArrayList<>();

    private Environment environment;

    public void addOrder(Order order){
        orderList.add(order);
    }

    /////////////////////循环执行 实现order列表中的命令////////////////////////

    public void executeAllOrder(){

        if(environment==null){
            /* 为功能执行命令而准备环境 */
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
