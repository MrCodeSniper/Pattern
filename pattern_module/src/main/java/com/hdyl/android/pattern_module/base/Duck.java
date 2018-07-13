package com.hdyl.android.pattern_module.base;

import com.hdyl.android.pattern_module.interfaces.DuckBehavior;

/**
 * Created by mac on 2018/7/9.
 */

public abstract class Duck {

    protected DuckBehavior.QuackBehavior quackBehavior;
    protected DuckBehavior.FlyBehavior flyBehavior;
    //这个类的变化之处在 fly和叫 把他们取出来


    public void setQuackBehavior(DuckBehavior.QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(DuckBehavior.FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void swim(){
        System.out.println("swim");
    }


    public abstract void display();

    public void performFly(){//不关心叫什么 只要知道它能叫即可
        flyBehavior.fly();
    }

    public void performQuark(){
        quackBehavior.quack();
    }

    /**
     *
     * 继承的缺点
     *
     * 1。改变牵一发而动全身
     * 2。我们都是继承父类的函数 不知道类确定的行为函数
     * 3。
     *
     *
     * Animal是个接口
     * Dog dog=new Dog();dog.func() 针对实现编程
     * Animal animal=new Dog() dog.func()针对接口编程
     * Animal a=getAnimal(); a.func(); 运行时决定运行方法
     *
     *
     *
     *
     */







}
