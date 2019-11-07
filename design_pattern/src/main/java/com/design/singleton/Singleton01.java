package com.design.singleton;

/**
 *  饱汉式单例，
 *
 *  懒汉模式在方法被调用后才创建对象，以时间换空间，在多线程环境下存在风险。
 *
 *  加入synchronized 性能会降低。
 *
 */
public class Singleton01  {

    //这里是volatile 很重要，不能去掉，防止jvm指令重排序。
    private static volatile Singleton01 singleton=null;

    private Singleton01() {
    }

    //直接在方法上加锁，性能太低 ，不推荐这样写
    public static  synchronized Singleton01 getInstance(){
        if (singleton == null){
            singleton = new Singleton01();
        }
        return singleton;
    }

}
