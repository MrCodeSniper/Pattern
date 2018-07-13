package com.hdyl.android.pattern_module.observer.view;

import com.hdyl.android.pattern_module.observer.DisplayBehavior;
import com.hdyl.android.pattern_module.observer.Observers;
import com.hdyl.android.pattern_module.observer.Subject;

/**
 * 观察者
 * Created by mac on 2018/7/9.
 */

public class CurrentConditionDisplay implements DisplayBehavior,Observers {

    private float temperture;
    private float humidity;
    private float pressure;


    protected Subject weatherData;


    public CurrentConditionDisplay(Subject weatherdata) {
        this.weatherData = weatherdata;
        weatherData.registerObserver(this);//注册观察者
    }

    public Subject getWeatherData() {
        return weatherData;
    }

    @Override
    public void show() {
        System.out.println(temperture+"&&"+humidity+"&&"+pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperture=temp;
        this.humidity=humidity;
        this.pressure=pressure;
        show();
    }






}
