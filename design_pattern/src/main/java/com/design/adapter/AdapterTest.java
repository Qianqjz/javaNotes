package com.design.adapter;

import org.junit.Test;

public class AdapterTest {

    @Test
    public void socketTest(){
        GuoJiSocket guoJiSocket=new GBSocketAdapter(new GBSocketImpl());
        GuoJiSocket guoJiSocket1=new DGSocketAdapter(new DGSocketImpl());
        DGHotel dgHotel=new DGHotel(guoJiSocket1);
        dgHotel.charge();
    }
}
