package com.hdyl.android.pattern_module.decoration.receipe;

import com.hdyl.android.pattern_module.base.Baverage;
import com.hdyl.android.pattern_module.base.Condiment;

/**
 * Created by mac on 2018/7/9.
 */

public class Whip extends Condiment {


    private Baverage baverage;


    public Whip(Baverage baverage) {
        this.baverage = baverage;
    }

    @Override
    public int cost() {
        return 2+baverage.cost();
    }

    @Override
    public String getDescription() {
        return baverage.getDescription()+",奶泡";
    }
}
