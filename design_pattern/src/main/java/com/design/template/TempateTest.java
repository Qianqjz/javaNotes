package com.design.template;

import org.junit.Test;

public class TempateTest  {

    @Test
    public void TemTest(){
        GetTimeTempate getTimeTempate=new ForDemo();
        long time=getTimeTempate.getTime();
        System.out.println(time);

        System.out.println("=================");

        GetTimeTempate getTimeTempate1=new CopyFileDemo();
        long time1=getTimeTempate1.getTime();
        System.out.println(time1);

    }

}

