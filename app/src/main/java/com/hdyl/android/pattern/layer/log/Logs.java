package com.hdyl.android.pattern.layer.log;

import android.util.Log;

/**
 * Created by mac on 2018/7/10.
 */

public class Logs {

    public static final String LOGTAG="LOGS";


    public void LogE(String msg){
        Log.e(LOGTAG,msg);
    }

    public void LogD(String msg){
        Log.d(LOGTAG,msg);
    }

}
