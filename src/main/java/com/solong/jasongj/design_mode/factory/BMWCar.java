package com.solong.jasongj.design_mode.factory;

/**
 * @Author znsong
 * @Date 2020/2/23 13:35
 */
@Vehicle(type = "BMW")
public class BMWCar extends Car {
    public BMWCar() {
    }


    @Override
    public void driver() {
        System.out.println(getName() + " the running.");
    }
}
