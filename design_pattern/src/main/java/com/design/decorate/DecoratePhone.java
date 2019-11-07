package com.design.decorate;

public class DecoratePhone implements Phone {

    private Phone phone;

    public DecoratePhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        phone.call();
    }
}
