package com.design.singleton;

/**
 * 内部类实现单例
 *
 */
public class Singleton03 {

    private Singleton03(){

    }

    private static class Holder{
        private static Singleton03 singleton03=new Singleton03();
    }

    public static Singleton03 getInstance(){
        return Holder.singleton03;
    }

}
