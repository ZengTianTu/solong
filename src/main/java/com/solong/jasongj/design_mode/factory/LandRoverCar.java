package com.solong.jasongj.design_mode.factory;

/**
 * @Author znsong
 * @Date 2020/2/23 13:33
 */
@Vehicle(type ="LandRover")
public class LandRoverCar extends Car{

    public LandRoverCar(){}

    @Override
    public void driver() {
        System.out.println(getName()+"  running.");
    }
}
