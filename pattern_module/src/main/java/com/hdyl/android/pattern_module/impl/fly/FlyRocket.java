package com.hdyl.android.pattern_module.impl.fly;

import com.hdyl.android.pattern_module.interfaces.DuckBehavior;

/**
 * Created by mac on 2018/7/9.
 */

public class FlyRocket implements DuckBehavior.FlyBehavior {
    @Override
    public void fly() {
        System.out.println("火箭头槌");
    }
}
