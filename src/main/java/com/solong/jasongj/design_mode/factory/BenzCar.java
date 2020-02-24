package com.solong.jasongj.design_mode.factory;

/**
 * @Author znsong
 * @Date 2020/2/23 13:35
 */
@Vehicle(type = "BenzCar")
public class BenzCar extends Car {

    public BenzCar() {
    }

    @Override

    public void driver() {
        System.out.println(getName() + "the running.");
    }
}
