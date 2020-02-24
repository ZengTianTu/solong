package com.solong.jasongj.design_mode.factory;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.reflections.Reflections;

import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author znsong
 * @Date 2020/2/23 10:35
 */
public class CarFactory {

    private static Map<String,Class> allCars;

    static {
        Reflections reflections = new Reflections("com.jasong.factory");
        Set<Class<?>> vehicleSet = reflections.getTypesAnnotatedWith(Vehicle.class);
        allCars = new ConcurrentHashMap<String,Class>();

        for (Class<?> aClass : vehicleSet) {
            Vehicle vehicle = (Vehicle) aClass.getAnnotation(Vehicle.class);
            allCars.put(vehicle.type(),aClass);
        }
        allCars = Collections.unmodifiableMap(allCars);
    }

    public static Car newCar(){
        Car car = null;
        try {
            XMLConfiguration config = new XMLConfiguration("car.xml");
            String type = config.getString("bestLike.name");
            if(allCars.containsKey(type)){
                car = (Car) allCars.get(type).newInstance();
            }
        } catch (ConfigurationException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return car;
    }

    public static void main(String[] args) {
        Car car = CarFactory.newCar();
        car.driver();
        System.out.println(car.getName());
    }

}
