package com.design.starategy;

public class AirplaneTravelStrategy implements TravelStratety {
    @Override
    public void travel() {
        System.out.println("开着飞机去游玩！");
    }
}
