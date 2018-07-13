package com.hdyl.android.pattern.layer.impl;

import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.hdyl.android.pattern.layer.interfaces.WebViewConfig;
import com.hdyl.android.pattern.layer.log.Environment;
import com.hdyl.android.pattern.layer.log.Logs;
import com.hdyl.android.pattern.layer.log.Order;

import static android.view.View.GONE;

/**
 * Created by mac on 2018/7/11.
 */

public class WebConfigImpl implements WebViewConfig,Order{

    private Logs logs;

    public WebConfigImpl(Logs logs) {
        this.logs = logs;
    }

    @Override
    public void execute(Environment environment) {
        logs.LogD("WebConfigImpl");
        environment.setOrder(this);
    }

    @Override
    public void setUpWebConfig(WebView webView) {
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        webView.setBackgroundColor(0);
        webView.getBackground().setAlpha(0);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(false);
        settings.setDomStorageEnabled(true);


        webView.loadUrl("file:///android_asset/index.html");
        webView.addJavascriptInterface(new Object() {

            @JavascriptInterface
            public void hidePopLayer() {
                webView.setVisibility(GONE);
            }
        }, "poplayer");
    }


    @Override
    public String toString() {
        return "WebConfig State";
    }
}
