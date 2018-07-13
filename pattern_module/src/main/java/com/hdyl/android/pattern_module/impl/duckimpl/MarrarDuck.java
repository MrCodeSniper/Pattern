package com.hdyl.android.pattern_module.impl.duckimpl;

import com.hdyl.android.pattern_module.base.Duck;
import com.hdyl.android.pattern_module.impl.fly.FlyNo;
import com.hdyl.android.pattern_module.impl.squake.Quack;
import com.hdyl.android.pattern_module.interfaces.DuckBehavior;

/**
 * Created by mac on 2018/7/9.
 */

public class MarrarDuck extends Duck {

    @Override
    public void display() {
        System.out.println("display:green head");
    }

    public MarrarDuck() { //初始化时 配置行为 半动态性 最好在父类中设置set就可以随时改变行为
        quackBehavior=new Quack();
        flyBehavior=new FlyNo();
    }
}
