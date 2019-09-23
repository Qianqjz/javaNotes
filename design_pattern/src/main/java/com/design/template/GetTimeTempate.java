package com.design.template;

/**
 * 抽象类就是一个模板，这模板主要也是spring事物的控制方式。
 */
public abstract class GetTimeTempate {

    public long getTime(){
        long startTime =System.currentTimeMillis();
        System.out.println("开始时间"+startTime);
        code();
        long endTime =System.currentTimeMillis();
        System.out.println("结束时间"+endTime);

        return endTime-startTime;
    }

    public abstract void code();
}
