package com.design.singleton;

/**
 *  饱汉式单例，
 *
 */
public class Singleton01  {

    //这里是volatile 很重要，不能去掉，防止jvm指令重排序。
    private static volatile Singleton01 singleton=null;

    private Singleton01() {
    }

    //直接在方法上加锁，性能太低 ，不推荐这样写
    public  synchronized Singleton01 getInstan(){
        if (singleton == null){
            singleton = new Singleton01();
        }
        return singleton;
    }

    //不直接在方法上加synchronized这样的性能会高一些
    public static Singleton01 getInstance(){
        if (singleton==null){
            synchronized (Singleton01.class){
                if (singleton == null){
                    singleton = new Singleton01();
                }
            }
        }
        return singleton;
    }

}
