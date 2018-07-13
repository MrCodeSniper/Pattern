package com.hdyl.android.pattern.layer.strategy;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/7/6.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;

public class LayerStrategyChooser {


    private ILayerStrategy iLayerStrategy;
    private Context mContext;

    public LayerStrategyChooser(ILayerStrategy iLayerStrategy, Context context) {
        this.iLayerStrategy = iLayerStrategy;
        this.mContext=context;
    }

    public void setLayerStrategy(ILayerStrategy iLayerStrategy) {
        this.iLayerStrategy = iLayerStrategy;
    }

    public void performDisplay(){
        this.iLayerStrategy.showLayer(mContext);
    }

    public void performDismiss(){
        this.iLayerStrategy.dismissLayer(mContext);
    }



}
