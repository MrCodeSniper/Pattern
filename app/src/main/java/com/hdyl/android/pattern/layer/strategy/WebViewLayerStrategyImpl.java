package com.hdyl.android.pattern.layer.strategy;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/7/6.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.hdyl.android.pattern.layer.view.webview.MyWebView;
import com.hdyl.android.pattern.R;
import com.hdyl.android.pattern.layer.interfaces.WebViewConfig;
import com.hdyl.android.pattern.layer.utils.LayerConfig;

import static android.view.View.GONE;

/**
 * @author  CH
 * 显示透明的wbview窗口
 */
public class WebViewLayerStrategyImpl implements ILayerStrategy {

    public static final String TAG="WebViewLayerStrategyIml";

    private WebViewConfig webViewConfig;
    private Bitmap bitmap;
    private int alpha;
    private static MyWebView myWebView;

    public WebViewLayerStrategyImpl(WebViewConfig webViewConfig) {
        this.webViewConfig = webViewConfig;
    }

    @Override
    public void showLayer(Context context) {

        myWebView=((Activity)context).findViewById(R.id.wv);
        if(myWebView!=null){
            myWebView.setVisibility(View.VISIBLE);
            return;
        }

        View view = View.inflate(context,R.layout.web_layout, null);
        myWebView = (MyWebView) view.findViewById(R.id.wv);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        webViewConfig.setUpWebConfig(myWebView, LayerConfig.redPocketScheme);
        myWebView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                bitmap=getBitmapFromView(myWebView);
                if (null != bitmap) {
                    int pixel = bitmap.getPixel((int)event.getX(), (int)event.getY());
                    alpha = Color.alpha(pixel);
                    Log.e(TAG,event.getX()+"**"+event.getY()+"**"+alpha);
                    bitmap.recycle();
                }

                if(alpha==255){//实体
                    Log.e(TAG,"设置触摸监听器:返回true");
                    return false;
                }

                Log.e(TAG,"设置触摸监听器:返回false");

                return false;
            }
        });
        ((Activity)context).getWindow().addContentView(view, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
    }

    @Override
    public void dismissLayer(Context context) {
        myWebView=((Activity)context).findViewById(R.id.wv);
        if(myWebView!=null){
            myWebView.setVisibility(GONE);
        }
    }

    @Override
    public void destroyLayer(Context context) {
        myWebView=((Activity)context).findViewById(R.id.wv);
        if(myWebView!=null){
            myWebView.stopLoading();
//            myWebView.setWebViewListener(null);
            myWebView.clearHistory();
            myWebView.clearCache(true);
            myWebView.loadUrl("about:blank");
            myWebView.pauseTimers();
            myWebView = null;
        }
    }


    /**
     * 获取view的bitmap
     * @param v
     * @return
     */
    public static Bitmap getBitmapFromView(View v) {
        Bitmap b = Bitmap.createBitmap(v.getWidth(), v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(b);
        v.layout(v.getLeft(), v.getTop(), v.getRight(), v.getBottom());
        // Draw background
        Drawable bgDrawable = v.getBackground();
        if (bgDrawable != null) {
            bgDrawable.draw(c);
        }
        else {
            c.drawColor(Color.WHITE);
        }
        // Draw view to canvas
        v.draw(c);
        return b;
    }

    }
