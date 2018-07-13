package com.hdyl.android.pattern.layer.impl;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/7/4.Best Wishes to You!  []~(~▽~)~* Cheers!


import com.hdyl.android.pattern.layer.interfaces.TimerManager;
import com.hdyl.android.pattern.layer.log.Environment;
import com.hdyl.android.pattern.layer.log.Logs;
import com.hdyl.android.pattern.layer.log.Order;

public class TimerManagerImpl implements TimerManager,Order {

    private Logs logs;

    public TimerManagerImpl(Logs logs) {
        this.logs = logs;
    }

    @Override
    public void execute(Environment environment) {
        logs.LogD("TimerManagerImpl");
        environment.setOrder(this);
    }

    @Override
    public String toString() {
        return "TimeM State";
    }
}
