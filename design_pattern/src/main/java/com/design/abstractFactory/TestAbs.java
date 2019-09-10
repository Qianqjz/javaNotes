package com.design.abstractFactory;

import org.junit.Test;

public class TestAbs {

    @Test
    public void testAbstract(){
        AnimalFactory animalFactory=CatFactory.getInstance();
        Animal animal = animalFactory.createAnimal();
        animal.eat();

        AnimalFactory animalFactory1=DogFactory.dogFactory();
        Animal animal1 = animalFactory1.createAnimal();
        animal1.eat();
    }
}
