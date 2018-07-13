package com.hdyl.android.pattern.layer.log;

import android.util.Log;

/**
 * 日志类
 * @author CH
 * Created by mac on 2018/7/10.
 */

public class Logs {

     private static final String logTag="LOGS";

    public void logE(String msg){
        Log.e(logTag,msg);
    }

    public void logD(String msg){
        Log.d(logTag,msg);
    }

}
