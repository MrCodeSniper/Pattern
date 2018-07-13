package com.hdyl.android.pattern_module.decoration.receipe;

import com.hdyl.android.pattern_module.base.Baverage;
import com.hdyl.android.pattern_module.base.Condiment;

/**
 * Created by mac on 2018/7/9.
 */

public class Moccha  extends Condiment {

    Baverage baverage;

    public Moccha(Baverage baverage) {//拿到具体组件
        this.baverage = baverage;
    }

    @Override
    public int cost() {
        return 3+baverage.cost();
    }

    @Override
    public String getDescription() {
        return baverage.getDescription()+",Mocha";
    }
}
