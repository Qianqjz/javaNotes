package com.design.adapter;

public class GBSocketAdapter implements GuoJiSocket {

    public GBSocket gbSocket;

    public GBSocketAdapter(GBSocket gbSocket) {
        this.gbSocket = gbSocket;
    }

    @Override
    public void method() {
        gbSocket.method();
    }
}
