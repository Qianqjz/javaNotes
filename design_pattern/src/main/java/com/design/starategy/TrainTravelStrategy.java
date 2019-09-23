package com.design.starategy;

public class TrainTravelStrategy implements TravelStratety {
    @Override
    public void travel() {
        System.out.println("坐着高铁去旅行！");
    }
}
