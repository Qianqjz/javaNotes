package com.spring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 默认加在Ioc容器中的组件，容器会调用无参构造，创建对象
 * 在进行赋值等操作
 */
@Component
public class Boss {

    private Car car;

//    @Autowired
    public Boss(@Autowired Car car){
        this.car=car;
        System.out.println("boss...有参数构造器。。");
    }


    public Car getCar() {
        return car;
    }

//    @Autowired//标注咋方法上，Spring容器在创建当前对象，就会调用方法，完成赋值
    //方法使用的参数，自定义类型的值从IOC容器中获取。
    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Boss{" +
                "car=" + car +
                '}';
    }
}
