package com.design.simpleFactory;

/**
 * 简单工厂，很实用，在接口转发、重定向时，很好用
 */
public class CarFactory {

    public Car car;

    public Car CreateCar(String carName){
        if ("A".equals(carName)){
            car=new AodiCar();
            car.setCarName("Aodi");
            car.setCarType("AoDi_AD");
        }else if ("T".equals(carName)) {
            car=new AotuoCar();
            car.setCarName("AoTuo");
            car.setCarType("AoTuo_AT");
        }
        return car;
    }
}
