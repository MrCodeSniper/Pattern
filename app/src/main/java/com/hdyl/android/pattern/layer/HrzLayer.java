package com.hdyl.android.pattern.layer;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/7/4.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.util.Log;

import com.hdyl.android.pattern.layer.impl.PushManagerImpl;
import com.hdyl.android.pattern.layer.impl.TimerManagerImpl;
import com.hdyl.android.pattern.layer.interfaces.HybirdManager;
import com.hdyl.android.pattern.layer.interfaces.LayerLifecycle;
import com.hdyl.android.pattern.layer.interfaces.NavigationManager;
import com.hdyl.android.pattern.layer.interfaces.PushManager;
import com.hdyl.android.pattern.layer.interfaces.TimerManager;
import com.hdyl.android.pattern.layer.interfaces.WebViewConfig;
import com.hdyl.android.pattern.layer.strategy.LayerStrategyChooser;

public class HrzLayer implements LayerLifecycle{
    private static final String TAG="HrzLayer";

    private TimerManager timerManagerImpl;
    private HybirdManager hybirdManagerImpl;
    private PushManager pushManagerImpl;
    private NavigationManager navigationManagerImpl;
    private WebViewConfig webViewConfigImpl;

    private static Builder builders;
    /** 选择器是 dialog 还是webview **/
    private LayerStrategyChooser layerStrategyChooser;

    //添加单例 使用内部类实现真正的延迟加载
    //当getInstance方法第一次被调用的时候，它第一次读取SingletonHolder.instance，
    // 内部类SingletonHolder类得到初始化；而这个类在装载并被初始化的时候，会初始化它的静态域，
    // 从而创建Singleton的实例，由于是静态的域，因此只会在虚拟机装载类的时候初始化一次，
    // 并由虚拟机来保证它的线程安全性。

    public static class Holder {
        static HrzLayer INSTANCE=new HrzLayer(builders);
    }

    public static HrzLayer getInstance(Builder builder){
        // 外围类能直接访问内部类（不管是否是静态的）的私有变量
        builders=builder;
        return Holder.INSTANCE;
    }

    private HrzLayer(Builder builder){//私有化构造
       initialize(builder);
       create();
   }

    private void initialize(Builder builder) {
        this.timerManagerImpl=builder.timerManagerImpl;
        this.hybirdManagerImpl=builder.hybirdManagerImpl;
        this.pushManagerImpl=builder.pushManagerImpl;
        this.navigationManagerImpl=builder.navigationManagerImpl;
        this.webViewConfigImpl=builder.webViewConfigImpl;
    }

   ///////////////////////////////////////////////////////////////////

   public static HrzLayer.Builder builder(){
       return new Builder();
   }

    public WebViewConfig getWebViewConfigImpl() {
        return webViewConfigImpl;
    }

    /**
     * 设置 初始化选择器 选择器会显示对应的view
     * @param layerStrategyChooser
     */
    public void setLayerStrategyChooser(LayerStrategyChooser layerStrategyChooser) {
        this.layerStrategyChooser = layerStrategyChooser;
    }

    /////////////////////////////////////生命周期接口实现////////////////////////////////////////////

    @Override
    public void onCreate() {
        Log.e(TAG,"poplayer初始化");
    }

    @Override
    public void onShow() {
        if(layerStrategyChooser!=null){
            Log.e(TAG,"poplayer显示");
            layerStrategyChooser.performDisplay();
        }
    }

    @Override
    public void onDismiss() {
        if(layerStrategyChooser!=null){
            Log.e(TAG,"poplayer消失");
            layerStrategyChooser.performDismiss();
        }
    }

    @Override
    public void onRecycle() {
        Log.e(TAG,"poplayer回收");
    }

   /////////////////////////////////////开放函数给外界调用////////////////////////////////////////////

    private void show(){
       onShow();
    }

    private void dismiss(){
        onDismiss();
    }

    private void create(){
        onCreate();
    }

    private void recycle(){
        onRecycle();
    }

    //////////////////////////////////内部类builder 配置适配层接口//////////////////////////////////////////////

    public static class Builder {

        private TimerManager timerManagerImpl;
        private HybirdManager hybirdManagerImpl;
        private PushManager pushManagerImpl;
        private NavigationManager navigationManagerImpl;
        private WebViewConfig webViewConfigImpl;

        public HrzLayer.Builder setTimerManagerImpl(TimerManagerImpl timerManagerImpls) {
            this.timerManagerImpl = timerManagerImpls;
            return this;
        }

        public HrzLayer.Builder setPushManagerImpl(PushManagerImpl pushManagerImpls) {
            this.pushManagerImpl = pushManagerImpls;
            return this;
        }

        public HrzLayer.Builder setWebViewConfigImpl(WebViewConfig webviewImpls) {
            this.webViewConfigImpl = webviewImpls;
            return this;
        }

        public HrzLayer build(){
            return new HrzLayer(this);
        }

    }




}
