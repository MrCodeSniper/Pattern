package com.hdyl.android.pattern_module.observer;

/**
 * Created by mac on 2018/7/9.
 */

public interface Subject {
    public void registerObserver(Observers o);
    public void removeObserver(Observers o);
    public void notifyObservers();

}
