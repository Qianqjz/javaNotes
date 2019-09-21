package com.design.adapter;


public class DGSocketAdapter implements GuoJiSocket {

    public DGSocket dgSocket;

    public DGSocketAdapter(DGSocket dgSocket) {
        this.dgSocket = dgSocket;
    }

    @Override
    public void method() {
        dgSocket.method();
    }
}
