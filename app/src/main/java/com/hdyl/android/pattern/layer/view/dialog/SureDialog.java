package com.hdyl.android.pattern.layer.view.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hdyl.android.pattern.R;


/**
 * Created by mac on 2018/5/9.
 */

public class SureDialog extends BaseDialog {

    private ImageView mIvLogo;
    private TextView mTvTitle;
    private TextView mTvContent;
    private TextView mTvSure;

    public SureDialog(Context context, int themeResId) {
        super(context, themeResId);
        this.initView();
    }

    public SureDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.initView();
    }

    public SureDialog(Context context) {
        super(context);
        this.initView();
    }

    public SureDialog(Context context, float alpha, int gravity) {
        super(context, alpha, gravity);
        this.initView();
    }

    public ImageView getLogoView() {
        return this.mIvLogo;
    }

    public TextView getTitleView() {
        return this.mTvTitle;
    }

    public TextView getSureView() {
        return this.mTvSure;
    }

    public void setSureListener(View.OnClickListener listener) {
        this.mTvSure.setOnClickListener(listener);
    }

    public TextView getContentView() {
        return this.mTvContent;
    }

    public void setLogo(int resId) {
        this.mIvLogo.setImageResource(resId);
    }

    public void setTitle(String title) {
        this.mTvTitle.setText(title);
    }

    public void setSure(String content) {
        this.mTvSure.setText(content);
    }

    public void setContent(String str) {
        //url text
//        if(RxRegTool.isURL(str)) {
//            this.mTvContent.setMovementMethod(LinkMovementMethod.getInstance());
//            this.mTvContent.setText(RxTextTool.getBuilder("",mContext).setBold().append(str).setUrl(str).create());
//        } else {
//            this.mTvContent.setText(str);
//        }
        this.mTvContent.setText(str);
    }

    private void initView() {
        View dialogView = LayoutInflater.from(this.getContext()).inflate(R.layout.dialog_sure, (ViewGroup)null);
        this.mTvSure = (TextView)dialogView.findViewById(R.id.tv_sure);
        this.mTvTitle = (TextView)dialogView.findViewById(R.id.tv_title);
        this.mTvTitle.setTextIsSelectable(true);
        this.mTvContent = (TextView)dialogView.findViewById(R.id.tv_content);
        this.mTvContent.setMovementMethod(ScrollingMovementMethod.getInstance());
        this.mTvContent.setTextIsSelectable(true);
        this.mIvLogo = (ImageView)dialogView.findViewById(R.id.iv_logo);
        this.setContentView(dialogView);
    }





}
