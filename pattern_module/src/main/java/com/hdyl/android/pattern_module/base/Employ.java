package com.hdyl.android.pattern_module.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mac on 2018/7/11.
 */

public class Employ {


    //累加起来为1个树形结构
    //Employ相当于根节点 列表相当于数干 但也可以是根节点







    private String name;
    private String dept;
    private int salary;
    private List<Employ> employList;

    public Employ(String name, String dept, int salary) {
        this.name = name;
        this.dept = dept;
        this.salary = salary;
        employList=new ArrayList<>();
    }

    public List<Employ> getEmployList() {
        return employList;
    }


    public void add(Employ employ){
        employList.add(employ);
    }

    public void remove(Employ employ){
        employList.remove(employ);
    }


    @Override
    public String toString() {
        return "Employ{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}
