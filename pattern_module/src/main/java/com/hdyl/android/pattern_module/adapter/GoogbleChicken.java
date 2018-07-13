package com.hdyl.android.pattern_module.adapter;

import com.hdyl.android.pattern_module.base.Duck;

/**
 * Created by mac on 2018/7/10.
 */

public class GoogbleChicken implements GoogbleType {
    @Override
    public void fly() {
        System.out.println("起飞");
    }

    @Override
    public void google() {
        System.out.println("谷歌搜索");
    }
}
