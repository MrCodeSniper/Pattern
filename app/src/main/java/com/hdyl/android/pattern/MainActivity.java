package com.hdyl.android.pattern;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.hdyl.android.pattern.layer.view.HrzLayerView;

import static com.hdyl.android.pattern.layer.view.HrzLayerView.STATE_DIALOG;
import static com.hdyl.android.pattern.layer.view.HrzLayerView.STATE_WEBVIEW;

public class MainActivity extends AppCompatActivity {

     static final String TAG="MainActivity";
     private HrzLayerView hrzLayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showDialog(View view){

        if(hrzLayerView!=null && hrzLayerView.state==STATE_WEBVIEW ){
            hrzLayerView=null;
        }

        if(hrzLayerView==null){
            hrzLayerView=new HrzLayerView(MainActivity.this,HrzLayerView.STATE_DIALOG);
        }else if(hrzLayerView.state==STATE_WEBVIEW){
            hrzLayerView=null;
        }

        if(hrzLayerView.isShow()){
            hrzLayerView.dismiss();
        }else {
            hrzLayerView.show();
        }

    }

    public void showWebview(View view){

        if(hrzLayerView!=null && hrzLayerView.state==STATE_DIALOG){
            hrzLayerView=null;
        }

        if(hrzLayerView==null){
            hrzLayerView=new HrzLayerView(MainActivity.this, STATE_WEBVIEW);
        }

        if(hrzLayerView.isShow()){
            hrzLayerView.dismiss();
        }else {
            hrzLayerView.show();
        }

    }
}


