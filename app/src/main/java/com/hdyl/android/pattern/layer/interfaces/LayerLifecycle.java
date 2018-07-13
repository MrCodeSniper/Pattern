package com.hdyl.android.pattern.layer.interfaces;

/**
 * Created by mac on 2018/7/10.
 */

public interface LayerLifecycle {

    void onCreate();
    void onShow();
    void onDismiss();
    void onRecycle();

}
