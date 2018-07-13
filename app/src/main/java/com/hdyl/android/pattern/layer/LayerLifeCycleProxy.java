package com.hdyl.android.pattern.layer;

import android.util.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by mac on 2018/7/10.
 */

public class LayerLifeCycleProxy  {

    private static final String TAG="LayerLifeCycleProxy";


    private Object target;

    public LayerLifeCycleProxy(Object target) {
        this.target = target;
    }



    public Object getProxyInstance(){
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Log.e(TAG,"动态代理1");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        Log.e(TAG,"动态代理2");
                        return returnValue;
                    }
                }

        );
    }












}
