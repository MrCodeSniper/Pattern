package com.hdyl.android.pattern_module.impl.squake;

import com.hdyl.android.pattern_module.interfaces.DuckBehavior;

/**
 * Created by mac on 2018/7/9.
 */

public class Squake implements DuckBehavior.QuackBehavior {
    @Override
    public void quack() {
        System.out.print("吱吱叫");
    }
}
