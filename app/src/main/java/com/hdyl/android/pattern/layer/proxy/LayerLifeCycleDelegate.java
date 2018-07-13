package com.hdyl.android.pattern.layer.proxy;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/7/4.Best Wishes to You!  []~(~▽~)~* Cheers!

import com.hdyl.android.pattern.layer.interfaces.LayerLifecycle;

/**
 * @author CH
 * poplayer生命周期代理管理 控制和代理访问 静态代理
 *
 */
@Deprecated
public class LayerLifeCycleDelegate implements LayerLifecycle{

    private LayerLifecycle target;

    public LayerLifeCycleDelegate(LayerLifecycle target) {
        this.target = target;
    }

    @Override
    public void onCreate() {
        target.onCreate();
    }

    @Override
    public void onShow() {
        target.onShow();
    }

    @Override
    public void onDismiss() {
        target.onDismiss();
    }

    @Override
    public void onRecycle() {
        target.onRecycle();
    }
}
