package com.design.abstractFactory;


public class DogFactory extends AnimalFactory{

    private DogFactory() {
    }

    public  Animal createAnimal() {
        return new Dog();
    }

    /**
     * 将构造方法私有化，只能通过静态方法来获取工厂方法，
     * @return
     */
    public static DogFactory dogFactory(){
        return new DogFactory();
    }

}
