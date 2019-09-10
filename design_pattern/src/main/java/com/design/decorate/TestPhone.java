package com.design.decorate;

import org.junit.Test;

public class TestPhone {
    @Test
    public void testPhone(){
        Phone phone=new DecoratePhone(new Iphone());
        phone.call();
    }

}
