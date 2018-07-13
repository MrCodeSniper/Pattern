package com.hdyl.android.pattern_module.impl.callImpl;

import com.hdyl.android.pattern_module.base.CallMachine;
import com.hdyl.android.pattern_module.interfaces.DuckBehavior;

/**
 * Created by mac on 2018/7/9.
 */

public class DuckCallMachine extends CallMachine {

    private DuckBehavior.QuackBehavior quackBehavior;

    public void setQuackBehavior(DuckBehavior.QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void performQuack(){
        if(quackBehavior!=null){
            quackBehavior.quack();
        }else {
            System.out.println("叫声代理为空");
        }
    }

    @Override
    public void makeSound() {
        performQuack();
    }
}
