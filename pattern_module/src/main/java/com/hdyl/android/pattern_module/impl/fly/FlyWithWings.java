package com.hdyl.android.pattern_module.impl.fly;

import com.hdyl.android.pattern_module.interfaces.DuckBehavior;

/**
 * Created by mac on 2018/7/9.
 */

public class FlyWithWings implements DuckBehavior.FlyBehavior {
    @Override
    public void fly() {
        System.out.print("边叫边飞");
    }
}
