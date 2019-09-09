package com.design.singleton;

/**
 *
 * 饿汉式单例
 *
 */
public class Singleton02 {

    private static Singleton02 singleton02=new Singleton02();

    private  Singleton02(){

    }
    public static synchronized Singleton02 getInstance(){
       return singleton02;
    }
}
