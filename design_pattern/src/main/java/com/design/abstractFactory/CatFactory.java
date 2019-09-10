package com.design.abstractFactory;

public class CatFactory extends AnimalFactory {

    private CatFactory(){

    }
    @Override
    public Animal createAnimal() {
        return new Cat();
    }

    public static CatFactory getInstance(){
        return new CatFactory();
    }

}
