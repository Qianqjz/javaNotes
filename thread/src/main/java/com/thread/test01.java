package com.thread;

/**
 * 学习
 * 多线程
 *
 * 线程的状态 new runable blocked wait time_wait termino.
 *
 * 线程死锁的条件，
 * 1.两个线程各自持有不同的锁
 * 2.两个线程各自视图获取对方持有的锁
 * 3.双方无线等待先去，形成死锁
 *
 * 避免死锁的方法是
 * 线程获取锁的顺序要一致、
 *
 *
 * yield()方法：暂停当前正在执行的线程对象，并执行其他线程。
 * join()方法： 线程实例的join()方法可以使得一个线程在另一个线程结束后再执行，
 *          即也就是说使得当前线程可以阻塞其他线程执行；
 *
 */

class ShareObject{
    private final Object lockA=new Object();
    private final Object lockB=new Object();

    private int accountA=1000;
    private int accountB=2000;

    public void a2b(int balance) {
        synchronized (lockA) {
            accountA-=balance;
            synchronized (lockB) {
                accountB+=balance;
            }
        }
    }
    public void b2a(int balance) {
        synchronized (lockB) {
            accountB-=balance;
            synchronized (lockA) {
                accountA+=balance;
            }
        }
    }
}

class AThread implements Runnable{

    public void run() {
        for(int i=0;i<test01.LOOP;i++) {
            test01.shared.a2b(1);
            if(i%100==0) {
                System.out.println(".");
            }
        }
    }

}

class BThread implements Runnable{

    public void run() {
        for(int i=0;i<test01.LOOP;i++) {
            test01.shared.b2a(1);
            if(i%100==0) {
                System.out.println(".");
            }
        }
    }

}

public class test01 {

    static int LOOP=1000;

    public static ShareObject shared=new ShareObject();

    @SuppressWarnings("static-access")
    public static void main(String[] args) {

        Thread t1=new Thread(new AThread());
        Thread t2=new Thread(new BThread());
        t1.start();
        t2.start();
        t1.yield();
        t2.yield();
        System.out.println("END!");
    }

}


