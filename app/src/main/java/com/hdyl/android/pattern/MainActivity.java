package com.hdyl.android.pattern;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.hdyl.android.pattern.layer.HrzLayer;
import com.hdyl.android.pattern.layer.HrzLayerView;
import com.hdyl.android.pattern.layer.LayerLifeCycleProxy;
import com.hdyl.android.pattern.layer.impl.OrderMaker;
import com.hdyl.android.pattern.layer.impl.PushManagerImpl;
import com.hdyl.android.pattern.layer.impl.TimerManagerImpl;
import com.hdyl.android.pattern.layer.interfaces.LayerLifecycle;
import com.hdyl.android.pattern.layer.log.LogInvoker;
import com.hdyl.android.pattern.layer.log.Logs;
import com.hdyl.android.pattern.layer.strategy.ILayerStrategy;
import com.hdyl.android.pattern.layer.strategy.LayerStrategyChooser;
import com.hdyl.android.pattern.layer.strategy.NativeLayerStrategyImpl;
import com.hdyl.android.pattern.layer.utils.GBData;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="MainActivity";

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"分发事件开始From Activity");
        return super.dispatchTouchEvent(ev);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //动态代理
//        LayerLifecycle target=new HrzLayer();
//        LayerLifecycle proxy= (LayerLifecycle) new LayerLifeCycleProxy(target).getProxyInstance();
//        proxy.onCreate();


//        LogInvoker logInvoker=new LogInvoker();
//        logInvoker.addOrder(orderMaker.getPushManagerImpl());
//        logInvoker.addOrder(orderMaker.getTimerManagerImpl());
//        logInvoker.executeAllOrder();
//        logInvoker.getEnvironment().getOrder().toString();

//        Logs logs=new Logs();
//        OrderMaker orderMaker=new OrderMaker(logs);
//
//
//
////        HrzLayer hrzLayer=HrzLayer.builder()
////                .setPushManagerImpl((PushManagerImpl) orderMaker.getPushManagerImpl())
////                .setTimerManagerImpl((TimerManagerImpl) orderMaker.getTimerManagerImpl())
////                .build();
////
//        HrzLayer hrzLayer = HrzLayer.getInstance(
//                 HrzLayer.builder()
//                .setPushManagerImpl((PushManagerImpl) orderMaker.getPushManagerImpl())
//                .setTimerManagerImpl((TimerManagerImpl) orderMaker.getTimerManagerImpl()));
//
//
//        ILayerStrategy iLayerStrategy=new NativeLayerStrategyImpl(R.layout.activity_main);
//        hrzLayer.setLayerStrategyChooser(new LayerStrategyChooser(iLayerStrategy,MainActivity.this));
//
//
//        LayerLifecycle proxy= (LayerLifecycle) new LayerLifeCycleProxy(hrzLayer).getProxyInstance();
//        proxy.onShow();
//
//        LogInvoker logInvoker=new LogInvoker();
//        logInvoker.addOrder(orderMaker.getPushManagerImpl());
//        logInvoker.addOrder(orderMaker.getTimerManagerImpl());
//        logInvoker.executeAllOrder();
//        logInvoker.getEnvironment().getOrder().toString();




//        hrzLayerView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Log.e(TAG,"yyyy");
//                hrzLayerView.dismiss();
//                return true;
//            }
//        });






    }



    public void showDialog(View view){
        HrzLayerView hrzLayerView=new HrzLayerView(MainActivity.this,HrzLayerView.STATE_DIALOG);
        hrzLayerView.show();
    }

    public void showWebview(View view){
        HrzLayerView hrzLayerView=new HrzLayerView(MainActivity.this,HrzLayerView.STATE_WEBVIEW);
        hrzLayerView.show();
    }





}


