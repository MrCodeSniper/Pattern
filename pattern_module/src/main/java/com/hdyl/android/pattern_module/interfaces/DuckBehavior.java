package com.hdyl.android.pattern_module.interfaces;

/**
 *
 * 把鸭子变化的行为全抽出来
 * 在执行时根据情况获取对应的行为 而不是绑死在父类
 * Created by mac on 2018/7/9.
 */

public interface DuckBehavior {

    public interface FlyBehavior{//由独立的行为实现类来实现
        void fly();
    }


    public interface QuackBehavior{//由独立的行为实现类来实现
        void quack();
    }
}
