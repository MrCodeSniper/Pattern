package com.hdyl.android.pattern.layer.strategy;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/7/6.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;

/**
 * @author CH
 * 准备使用策略模式 动态改变算法
 */
public interface ILayerStrategy {
     void showLayer(Context context);
     void dismissLayer(Context context);
     void destroyLayer(Context context);
}
