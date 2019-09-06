package com.thread;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ReentrantLock可以替代synchronized,更加安全
 * 但是要在try..finally中释放锁
 * 保证临界区只有一个线程执行
 *
 * 可以使用tryLock()给锁加个失效时间
 *
 *
 */
class Counter{

    private final Lock lock=new ReentrantLock();

    private int value = 0;

    public void add(int m){
        lock.lock();
        try {
            value+=m;
        }finally {
            lock.unlock();
        }
    }

    public void dec(int m){
        lock.lock();
        try {
            value-=m;
        }finally {
            lock.unlock();
        }
    }
    public int get(){
        lock.lock();
        try {
            return value;
        }finally {
            lock.unlock();
        }
    }
}

public class Test06 {

    final static int LOOP =1000;

    public static void main(String[] args) throws InterruptedException {
        final Counter counter=new Counter();
        Thread t1=new Thread(){
            public void run(){
                for (int i=0;i<LOOP;i++){
                    counter.add(1);
                }
            }
        };

        Thread t2=new Thread(){
            public void run(){
                for (int i=0;i<LOOP;i++){
                    counter.dec(1);
                }
            }
        };

        t1.start();
        t2.start();
        t1.join();
        t1.join();
        System.out.println("结果 ："+counter.get());
    }

}
