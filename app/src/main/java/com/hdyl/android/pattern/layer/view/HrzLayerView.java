package com.hdyl.android.pattern.layer.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.hdyl.android.pattern.R;
import com.hdyl.android.pattern.layer.HrzLayer;
import com.hdyl.android.pattern.layer.proxy.LayerLifeCycleProxy;
import com.hdyl.android.pattern.layer.impl.OrderMaker;
import com.hdyl.android.pattern.layer.impl.PushManagerImpl;
import com.hdyl.android.pattern.layer.impl.TimerManagerImpl;
import com.hdyl.android.pattern.layer.interfaces.LayerLifecycle;
import com.hdyl.android.pattern.layer.interfaces.WebViewConfig;
import com.hdyl.android.pattern.layer.log.LogInvoker;
import com.hdyl.android.pattern.layer.log.Logs;
import com.hdyl.android.pattern.layer.strategy.ILayerStrategy;
import com.hdyl.android.pattern.layer.strategy.LayerStrategyChooser;
import com.hdyl.android.pattern.layer.strategy.NativeLayerStrategyImpl;
import com.hdyl.android.pattern.layer.strategy.WebViewLayerStrategyImpl;

/**
 * Created by mac on 2018/7/10.
 */

public class HrzLayerView extends View {

    static final String TAG="HrzLayerView";

    private boolean isShow=false;

    public static int STATE_WEBVIEW=1;
    public static int STATE_DIALOG=0;

    public int state=-1;

    private ILayerStrategy iLayerStrategy;

    private Context mContext;

    private LayerLifecycle proxy;

    public HrzLayerView(Context context,int state) {
        super(context);
        mContext=context;
        this.state=state;
        initLayerView();
    }

    public HrzLayerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext=context;
        initLayerView();
    }

    public HrzLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext=context;
        initLayerView();
    }

    private void initLayerView() {
        //日志类初始化
        Logs logs=new Logs();
        // 初始化时 会实例化功能接口的实现
        OrderMaker orderMaker=new OrderMaker(logs);

        HrzLayer.Builder builder=HrzLayer.builder()
                .setPushManagerImpl((PushManagerImpl) orderMaker.getPushManagerImpl())
                .setTimerManagerImpl((TimerManagerImpl) orderMaker.getTimerManagerImpl())
                .setWebViewConfigImpl((WebViewConfig) orderMaker.getWebConfigManagerImpl());

        HrzLayer hrzLayer = HrzLayer.getInstance(builder);

        if(state==STATE_DIALOG){
            iLayerStrategy=new NativeLayerStrategyImpl(R.layout.activity_main);
            ((NativeLayerStrategyImpl)iLayerStrategy).setOnClickDismissListener(new NativeLayerStrategyImpl.onClickDismissListener() {
                @Override
                public void onDismissLayer() {
                   dismiss();
                }
            });
        }else if(state==STATE_WEBVIEW){
            iLayerStrategy=new WebViewLayerStrategyImpl(hrzLayer.getWebViewConfigImpl());
        }else {
            iLayerStrategy=null;
            return;
        }

        hrzLayer.setLayerStrategyChooser(new LayerStrategyChooser(iLayerStrategy,mContext));
        proxy= (LayerLifecycle) new LayerLifeCycleProxy(hrzLayer).getProxyInstance();
        //日志管理类实例化
        LogInvoker logInvoker=new LogInvoker();
        logInvoker.addOrder(orderMaker.getPushManagerImpl());
        logInvoker.addOrder(orderMaker.getTimerManagerImpl());
        logInvoker.executeAllOrder();
        logInvoker.getEnvironment().getOrder().toString();
    }


    public void show(){
        Log.e(TAG,"显示了");
        proxy.onShow();
        isShow=true;
    }

    public void dismiss(){
        Log.e(TAG,"消失了");
        proxy.onDismiss();
        isShow=false;
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG,event.toString());
        return super.dispatchTouchEvent(event);
    }

    public boolean isShow() {
        return isShow;
    }
}
