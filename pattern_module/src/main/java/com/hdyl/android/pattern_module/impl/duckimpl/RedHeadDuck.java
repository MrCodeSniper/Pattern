package com.hdyl.android.pattern_module.impl.duckimpl;

import com.hdyl.android.pattern_module.base.Duck;
import com.hdyl.android.pattern_module.interfaces.Flyable;
import com.hdyl.android.pattern_module.interfaces.Quarkable;

/**
 * Created by mac on 2018/7/9.
 */

public class RedHeadDuck extends Duck implements Quarkable,Flyable{

    @Override
    public void display() {
        System.out.println("display:red head");
    }

    @Override
    public void quack() {
        System.out.println("quack");
    }

    @Override
    public void fly() {
        System.out.println("fly");
    }
}
