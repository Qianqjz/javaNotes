package com.design.simpleFactory;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * 学习使用Lombok
 *
 */
@NoArgsConstructor
@Data
@Accessors
public class Car {
    private String carName;
    private String carType;

    public Car(String carName, String carType) {
        this.carName = carName;
        this.carType = carType;
    }
}
