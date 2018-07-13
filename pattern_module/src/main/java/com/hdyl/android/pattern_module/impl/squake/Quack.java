package com.hdyl.android.pattern_module.impl.squake;

import com.hdyl.android.pattern_module.interfaces.DuckBehavior;

/**
 * 这些实现具体的行为称为鸭子的算法
 * Created by mac on 2018/7/9.
 */

public class Quack implements DuckBehavior.QuackBehavior {
    @Override
    public void quack() {
        System.out.print("呱呱叫");
    }
}
