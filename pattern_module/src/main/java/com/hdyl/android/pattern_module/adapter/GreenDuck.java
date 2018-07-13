package com.hdyl.android.pattern_module.adapter;

import com.hdyl.android.pattern_module.base.Duck;

/**
 * Created by mac on 2018/7/10.
 */

public class GreenDuck implements DuckType {
    @Override
    public void fly() {
        System.out.println("起飞");
    }

    @Override
    public void swim() {
        System.out.println("游泳");
    }
}
