package com.design.simpleFactory;

import org.junit.Test;

public class TestSimple {

    @Test
    public void testSimpleFactory(){
        CarFactory carFactory=new CarFactory();
        Car a = carFactory.CreateCar("A");
        System.out.println("这是一辆 "+a.getCarType()+"类型的"+a.getCarName()+"车！");
        Car t = carFactory.CreateCar("T");
        System.out.println("这是一辆 "+t.getCarType()+"类型的"+t.getCarName()+"车！");
    }
}
