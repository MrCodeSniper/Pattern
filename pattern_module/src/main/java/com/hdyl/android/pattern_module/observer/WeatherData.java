package com.hdyl.android.pattern_module.observer;

import java.util.ArrayList;

/**
 * Created by mac on 2018/7/9.
 */

public class WeatherData  implements Subject{//

    private ArrayList<Observers> observersArrayList;
    private float temperture;
    private float humidity;
    private float pressure;


    public WeatherData() {
        observersArrayList=new ArrayList<>();//内部维护一拖观察者
    }

    public float getTemperture() {
        return temperture;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    public void setMeasurements(float temperture,float humidity,float pressure) {
        this.temperture = temperture;
        this.humidity=humidity;
        this.pressure=pressure;
        measureMomentChanged();
    }

    public void measureMomentChanged(){
        notifyObservers();
    }


    @Override
    public void registerObserver(Observers o) {
        observersArrayList.add(o);
    }

    @Override
    public void removeObserver(Observers o) {
        observersArrayList.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observers observers:observersArrayList) {
            observers.update(temperture,humidity,pressure);
        }
    }
}
