package com.hdyl.android.pattern.layer.impl;

import android.os.Build;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.hdyl.android.pattern.layer.interfaces.WebViewConfig;
import com.hdyl.android.pattern.layer.log.Environment;
import com.hdyl.android.pattern.layer.log.Logs;
import com.hdyl.android.pattern.layer.log.Order;

import static android.view.View.GONE;

/**
 * Created by mac on 2018/7/11.
 */

public class WebConfigImpl implements WebViewConfig,Order{
    static final String TAG="WebConfigImpl";

    private Logs logs;

     WebConfigImpl(Logs logs) {
        this.logs = logs;
    }

    @Override
    public void execute(Environment environment) {
        logs.logE("WebConfigImpl");
        environment.setOrder(this);
    }

    ///////////////////////////////////////配置WEBVIEW 待后续继续优化 参考网易考拉团队webview优化////////////////////////////////

    @Override
    public void setUpWebConfig(WebView webView,String showScheme) {
        // setup wv
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        webView.setWebChromeClient(new WebChromeClient());
//        wv.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        WebSettings settings = webView.getSettings();
        webView.setBackgroundColor(0);
        webView.getBackground().setAlpha(0);
//        settings.setAllowUniversalAccessFromFileURLs(true);
        settings.setJavaScriptEnabled(true);
//        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setAppCacheEnabled(false);
        settings.setDomStorageEnabled(true);

        webView.loadUrl(showScheme);
        webView.addJavascriptInterface(new Object() {
            @JavascriptInterface
            public void hidePopLayer() {
                webView.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.e("chnehong","xxx");
                        webView.setVisibility(GONE);
                    }
                });
            }
        }, "poplayer");

//        webView.loadUrl(showScheme);
//        //增加js 调用的对象 poplayer.hidePopLayer() webview消失
//        webView.addJavascriptInterface(new Object() {
//            @JavascriptInterface
//            public void hidePopLayer() {
//                Log.e(TAG,"js调用了隐藏layer");
//                webView.setVisibility(GONE);
//            }
//        }, "poplayer");

    }

    @Override
    public String toString() {
        return "WebConfig State";
    }
}
