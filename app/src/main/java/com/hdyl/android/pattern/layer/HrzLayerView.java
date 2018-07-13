package com.hdyl.android.pattern.layer;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.hdyl.android.pattern.MainActivity;
import com.hdyl.android.pattern.R;
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

    public static int STATE_WEBVIEW=1;
    public static int STATE_DIALOG=0;

    public int state=-1;

    private ILayerStrategy iLayerStrategy;
    public static final String TAG="HrzLayerView";


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

        Logs logs=new Logs();
        OrderMaker orderMaker=new OrderMaker(logs);

        HrzLayer.Builder builder=HrzLayer.builder()
                .setPushManagerImpl((PushManagerImpl) orderMaker.getPushManagerImpl())
                .setTimerManagerImpl((TimerManagerImpl) orderMaker.getTimerManagerImpl())
                .setWebViewConfigImpl((WebViewConfig) orderMaker.getWebConfigManagerImpl());

        HrzLayer hrzLayer = HrzLayer.getInstance(builder);


        if(state==STATE_DIALOG){
            iLayerStrategy=new NativeLayerStrategyImpl(R.layout.activity_main);
        }else if(state==STATE_WEBVIEW){
            iLayerStrategy=new WebViewLayerStrategyImpl(hrzLayer.getWebViewConfigImpl());
        }else {
            iLayerStrategy=null;
            return;
        }




        hrzLayer.setLayerStrategyChooser(new LayerStrategyChooser(iLayerStrategy,mContext));

        proxy= (LayerLifecycle) new LayerLifeCycleProxy(hrzLayer).getProxyInstance();

        LogInvoker logInvoker=new LogInvoker();
        logInvoker.addOrder(orderMaker.getPushManagerImpl());
        logInvoker.addOrder(orderMaker.getTimerManagerImpl());
        logInvoker.executeAllOrder();
        logInvoker.getEnvironment().getOrder().toString();

    }


    public void show(){
        proxy.onShow();
    }

    public void dismiss(){
        proxy.onDismiss();
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        Log.e(TAG,event.toString());
        return super.dispatchTouchEvent(event);
    }
}
