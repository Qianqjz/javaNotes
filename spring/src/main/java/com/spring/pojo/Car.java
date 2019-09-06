package com.spring.pojo;

import org.springframework.stereotype.Component;

@Component
public class Car {

    public Car() {
        System.out.println("car construstor...");
    }

    public void init(){
        System.out.println("car...init..");
    }

    public void destroy(){
        System.out.println("car...destory..");
    }

}
