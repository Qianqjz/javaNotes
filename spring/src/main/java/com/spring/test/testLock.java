package com.spring.test;

import org.junit.Test;

/**
 * 死锁代码范例：测试
 */
public class testLock {

    private  Object lock1=new Object();
    private  Object lock2=new Object();

    @Test
    public  void test01(){
        new Thread(){
            public void run(){
                synchronized (lock1){
                    System.out.println("thread1 get lock1");
                    try{
                        Thread.sleep(100);

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    synchronized (lock2){
                        System.out.println("thread2 get lock2");
                    }
                }
                System.out.println("thread1 end");
            }
        }.start();

        new Thread(){
            public void run(){
                synchronized (lock2){
                    System.out.println("thread2 get lock1");
                    try{
                        Thread.sleep(100);

                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    synchronized (lock1){
                        System.out.println("thread1 get lock2");
                    }
                }
                System.out.println("thread2 end");
            }
        }.start();
    }

}
