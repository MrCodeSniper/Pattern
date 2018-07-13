package com.hdyl.android.pattern.layer.view.webview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;

/**
 * @Author
 * Created by mac on 2018/7/11.
 */
public class MyWebView extends WebView {

    public static final String TAG="MyWebView";

    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.e(TAG,"WEBVIEW收到分发事件");
        return super.dispatchTouchEvent(ev);
    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        Log.e(TAG,"WEBVIEW收到触摸事件"+super.onTouchEvent(event));
//        return false;
//    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Log.e(TAG,"WEBVIEW拦截事件");
        return super.onInterceptTouchEvent(ev);
    }

}
