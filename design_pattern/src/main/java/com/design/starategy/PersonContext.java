package com.design.starategy;

public class PersonContext {

    public TravelStratety travelStratety;

    public PersonContext(TravelStratety travelStratety) {
        this.travelStratety = travelStratety;
    }

    public void travel(){
        travelStratety.travel();
    }
}
