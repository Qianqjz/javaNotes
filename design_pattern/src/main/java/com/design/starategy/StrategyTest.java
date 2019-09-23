package com.design.starategy;

import org.junit.Test;

public class StrategyTest {

    @Test
    public void StrTest(){
        //传入一种策略
        AirplaneTravelStrategy airplaneTravelStrategy=new AirplaneTravelStrategy();
        PersonContext personContext=new PersonContext(airplaneTravelStrategy);
        personContext.travel();

    }
}
