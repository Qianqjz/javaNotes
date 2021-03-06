package com.design.delegate;

/**
 * delegate委托模式或者叫委派模式
 *
 * delegate模式，不在23种设计模式之内，但是使用这种模式的应用很多。
 *
 * delegate模式的表现：看似是一个对象完成的功能，但是实质上通过两个对象去实现一个功能。
 * 	比如说项目经理和开发人员的关系，客户只告诉项目经理说做什么需求，
 * 	但是项目经理没有真正自己去实现该需求，是安排开发人员去实现需求
 *
 * delegate模式需要的两个对象之间没有关系。
 *
 * 这种模式在spring框架中很常见。
 *
 */
public class DeveManger {

    private Developer delegate=new Developer();

    public void doSomeThing(){
        delegate.doSomeThing();
    }
}
