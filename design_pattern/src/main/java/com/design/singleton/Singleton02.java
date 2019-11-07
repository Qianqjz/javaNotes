package com.design.singleton;

/**
 *
 * 饿汉式单例
 * 饿汉模式在类被初始化时就已经在内存中创建了对象，以空间换时间，故不存在线程安全问题。
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
