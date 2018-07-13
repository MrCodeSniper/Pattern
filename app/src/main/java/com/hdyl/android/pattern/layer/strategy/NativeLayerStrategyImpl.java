package com.hdyl.android.pattern.layer.strategy;
//Thanks For Your Reviewing My Code 
//Please send your issues email to 15168264355@163.com when you find there are some bugs in My class 
//You Can add My wx 17620752830 and we can communicate each other about IT industry
//Code Programming By MrCodeSniper on 2018/7/6.Best Wishes to You!  []~(~▽~)~* Cheers!


import android.content.Context;
import android.view.View;

import com.hdyl.android.pattern.layer.view.dialog.SureDialog;

public class NativeLayerStrategyImpl implements ILayerStrategy{

    private int layoutRes;

    private SureDialog dialog;

    public interface onClickDismissListener{
        void onDismissLayer();
    }

    private onClickDismissListener onClickDismissListener;

    public void setOnClickDismissListener(NativeLayerStrategyImpl.onClickDismissListener onClickDismissListener) {
        this.onClickDismissListener = onClickDismissListener;
    }

    /** 原生dialog需要传dialog的布局 **/
    public NativeLayerStrategyImpl(int layoutRes) {
        this.layoutRes = layoutRes;
    }

    @Override
    public void showLayer(Context context) {
        if(dialog==null){
            dialog=new SureDialog(context);
        }
        dialog.getLogoView().setVisibility(View.GONE);
        dialog.getTitleView().setVisibility(View.GONE);
        dialog.setSure("确认");
        dialog.setContent("弹出框测试");
        dialog.getSureView().setOnClickListener((View v)-> {
           if(onClickDismissListener!=null){
               onClickDismissListener.onDismissLayer();
           }
        });
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void dismissLayer(Context context) {
        if(dialog!=null){
            dialog.cancel();
        }
    }

    @Override
    public void destroyLayer(Context context) {
        if(dialog!=null){
            dialog.cancel();
        }
    }


}
