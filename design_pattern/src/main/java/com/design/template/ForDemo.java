package com.design.template;

public class ForDemo extends GetTimeTempate {

    public void code(){
        int sum=0;
        for (int i=0;i<10000000;i++){
            sum+=i;
        }
    }
}
