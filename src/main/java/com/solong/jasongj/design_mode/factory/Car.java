package com.solong.jasongj.design_mode.factory;

/**
 * @Author znsong
 * @Date 2020/2/23 10:37
 */
public abstract class Car {

    private String name;

    public Car(){}

    public String getName() {
        return name;
    }


    public abstract void driver();

}
