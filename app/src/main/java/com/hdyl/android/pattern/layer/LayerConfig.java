package com.hdyl.android.pattern.layer;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/7/4.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;

import com.hdyl.android.pattern.layer.impl.TimerManagerImpl;
import com.hdyl.android.pattern.layer.interfaces.HybirdManager;
import com.hdyl.android.pattern.layer.interfaces.NavigationManager;
import com.hdyl.android.pattern.layer.interfaces.PushManager;
import com.hdyl.android.pattern.layer.interfaces.TimerManager;
import com.hdyl.android.pattern.layer.interfaces.WebViewConfig;


//适配层 包含 推送，导航，时间管理，webview管理，Rn界面管理
public class LayerConfig {



  //策略模式定义了一系列的算法，并将每一个算法封装起来，而且使他们可以相互替换，让算法独立于使用它的客户而独立变化。







    private TimerManager mTimerManager;
    private HybirdManager mHybirdManager;
    private PushManager mPushManager;
    private NavigationManager mNavigationManager;
    private WebViewConfig mWebViewConfig;



    public LayerConfig(Builder builder) {

        this.mTimerManager=builder.timerManagerImpl;
        this.mHybirdManager=builder.hybirdManagerImpl;
        this.mPushManager=builder.pushManagerImpl;
        this.mNavigationManager=builder.navigationManagerImpl;
        this.mWebViewConfig=builder.webViewConfigImpl;


    }

    /**
     * 获取建造者
     * @return {@link Builder}
     */
    public static Builder getBuilder(Context context) {
        return new Builder(context);
    }




    /**
     * 内部类builder 配置适配层接口
     */
    public static class Builder {

        private Context mContext;
        private TimerManager timerManagerImpl;
        private HybirdManager hybirdManagerImpl;
        private PushManager pushManagerImpl;
        private NavigationManager navigationManagerImpl;
        private WebViewConfig webViewConfigImpl;


        public Builder(Context mContext) {
            this.mContext = mContext;
            //初始化操作
        }

        public Builder setTimerManagerImpl(TimerManagerImpl timerManagerImpl) {
            this.timerManagerImpl = timerManagerImpl;
            return this;
        }



    }




}
