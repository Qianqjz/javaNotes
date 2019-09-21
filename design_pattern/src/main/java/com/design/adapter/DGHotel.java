package com.design.adapter;

/**
 * 适配器模式 将一个类的接口转换成另外一个客户希望的接口
 *
 */

public class DGHotel {

    public  GuoJiSocket guoJiSocket;

    public DGHotel(GuoJiSocket guoJiSocket) {
        this.guoJiSocket = guoJiSocket;
    }

    public void setGuoJiSocket(GuoJiSocket guoJiSocket) {
        this.guoJiSocket = guoJiSocket;
    }

    public void charge(){
        guoJiSocket.method();
    }
}
