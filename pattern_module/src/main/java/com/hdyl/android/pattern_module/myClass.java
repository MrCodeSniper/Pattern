package com.hdyl.android.pattern_module;

import com.hdyl.android.pattern_module.base.Baverage;
import com.hdyl.android.pattern_module.base.CallMachine;
import com.hdyl.android.pattern_module.base.Duck;
import com.hdyl.android.pattern_module.decoration.DarkRoast;
import com.hdyl.android.pattern_module.decoration.receipe.Moccha;
import com.hdyl.android.pattern_module.decoration.receipe.Whip;
import com.hdyl.android.pattern_module.impl.callImpl.DuckCallMachine;
import com.hdyl.android.pattern_module.impl.duckimpl.MarrarDuck;
import com.hdyl.android.pattern_module.impl.duckimpl.RedHeadDuck;
import com.hdyl.android.pattern_module.impl.fly.FlyRocket;
import com.hdyl.android.pattern_module.impl.squake.Quack;
import com.hdyl.android.pattern_module.interfaces.Flyable;
import com.hdyl.android.pattern_module.observer.DisplayBehavior;
import com.hdyl.android.pattern_module.observer.Observers;
import com.hdyl.android.pattern_module.observer.WeatherData;
import com.hdyl.android.pattern_module.observer.view.CurrentConditionDisplay;

public class myClass {


    public static void main(String[] args){
        Duck duck=new RedHeadDuck();//向⬆转型
        Flyable flyable= (Flyable) duck;//接口实例化
        flyable.fly();//接口的问题是不能复用

        Duck duck1=new MarrarDuck();
        //先执行初始化的
        duck1.performFly();
        duck1.performQuark();
        //再执行设置的
        duck1.setFlyBehavior(new FlyRocket()); //这种动态改变运行的就是策略模式
        duck1.performFly();

        CallMachine duckCallMachine=new DuckCallMachine();
        duckCallMachine.makeSound();
        ((DuckCallMachine)duckCallMachine).setQuackBehavior(new Quack());
        duckCallMachine.makeSound();

        WeatherData weatherData=new WeatherData();
        weatherData.setMeasurements(1f,1f,1f);

        Observers currentConditionObserver=new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(2f,2f,2f);
        ((CurrentConditionDisplay)currentConditionObserver).getWeatherData().removeObserver(currentConditionObserver);
        weatherData.setMeasurements(3f,3f,3f);


        Baverage baverage=new DarkRoast();
        baverage=new Moccha(baverage);
        baverage=new Moccha(baverage);
        baverage=new Whip(baverage);

        //一层套一层

        System.out.println(baverage.getDescription()+"&&"+baverage.cost());


    }




}
