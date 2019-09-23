package com.design.starategy;

public class CarTravelStrategy implements TravelStratety {
    @Override
    public void travel() {
        System.out.println("开着小车去旅行！");
    }
}
