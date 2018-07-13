package com.hdyl.android.pattern.layer.impl;

import com.hdyl.android.pattern.layer.interfaces.PushManager;
import com.hdyl.android.pattern.layer.log.Environment;
import com.hdyl.android.pattern.layer.log.Logs;
import com.hdyl.android.pattern.layer.log.Order;

/**
 * Created by mac on 2018/7/10.
 */

public class PushManagerImpl implements PushManager,Order {

    private Logs logs;

    public PushManagerImpl(Logs logs) {
        this.logs = logs;
    }


    @Override
    public void execute(Environment environment) {
        logs.LogE("PushManagerImpl");
        environment.setOrder(this);
    }


    @Override
    public String toString() {
        return "Push State";
    }
}
