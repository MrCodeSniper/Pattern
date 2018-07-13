package com.hdyl.android.pattern.layer.strategy;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/7/6.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;

public interface ILayerStrategy {
    public void showLayer(Context context);
    public void dismissLayer(Context context);
    public void destroyLayer(Context context);
}
