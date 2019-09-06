package com.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomic 原子操作
 * CAS compare and set
 *
 * 适用于计数器，累加器
 */
class Atomic {
    private AtomicInteger value =new AtomicInteger(0);

    public int add(int m){
        return value.addAndGet(m);
    }

    public int dec(int m){
        return value.addAndGet(-m);
    }
    public int get(){
        return value.get();
    }
}

public class Test09 {

    private static final int LO=1000;

    public static void main(String[] args) throws InterruptedException {
        final Atomic atomic=new Atomic();

        Thread t1=new Thread(){
            public void run(){
                for (int i=0;i<LO;i++){
                    atomic.add(1);
                }
            }
        };

        Thread t2=new Thread(){
            public void run(){
                for (int i=0;i<LO;i++){
                    atomic.dec(1);
                }
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(atomic.get());
    }
}
