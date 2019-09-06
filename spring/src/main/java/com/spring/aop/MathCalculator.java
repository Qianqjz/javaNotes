package com.spring.aop;

public class MathCalculator {
    public int div(int i,int j){
        //耦合度太高，不能使用
        System.out.println("MathCalculator...div....");
        return i/j;
    }

}
