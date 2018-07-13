package com.hdyl.android.pattern_module.adapter;

/**
 * Created by mac on 2018/7/10.
 */

public class TurkeyAdapter implements DuckType {

    private GoogbleChicken googbleChicken;

    @Override
    public void fly() {
        googbleChicken.fly();
    }

    @Override
    public void swim() {
      for(int i=0;i<5;i++){
          googbleChicken.google();
      }
    }
}
