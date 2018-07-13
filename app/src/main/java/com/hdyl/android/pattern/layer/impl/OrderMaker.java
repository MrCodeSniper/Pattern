package com.hdyl.android.pattern.layer.impl;

import com.hdyl.android.pattern.layer.log.Environment;
import com.hdyl.android.pattern.layer.log.Logs;
import com.hdyl.android.pattern.layer.log.Order;

/**
 * @author  CH
 * 命令模式 为每个功能装配一个log命令
 * Created by mac on 2018/7/10.
 */

public class OrderMaker {

    private Order pushManagerImpl;
    private Order timerManagerImpl;
    private Order webConfigManagerImpl;

    public OrderMaker(Logs log) {
        this.pushManagerImpl = new PushManagerImpl(log);
        this.timerManagerImpl = new TimerManagerImpl(log);
        this.webConfigManagerImpl=new WebConfigImpl(log);
    }

    public Order getPushManagerImpl() {
        return pushManagerImpl;
    }

    public Order getWebConfigManagerImpl() {
        return webConfigManagerImpl;
    }

    public Order getTimerManagerImpl() {
        return timerManagerImpl;
    }

    public void pushLog(Environment environment){ pushManagerImpl.execute(environment); }
    public void timeLog(Environment environment){ timerManagerImpl.execute(environment); }
    public void webLog(Environment environment){ webConfigManagerImpl.execute(environment); }

}
