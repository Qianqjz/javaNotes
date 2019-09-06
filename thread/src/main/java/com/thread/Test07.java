package com.thread;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * ReentrantLock 可以保证在临界区，只有一个线程在执行，
 * 但是在读的时候没有这个必要，
 * 一般读的时候允许多个线程读，写的时候只允许一个线程写
 *
 *  readwriterlock
 *  只允许一个线程写入 其他线程既不允许读，也不允许写
 *  没有写时，可以允许多个线程读 提高了性能
 *
 *  适合读多写少的场景
 *
 */

class Couter{

    private final ReadWriteLock lock=new ReentrantReadWriteLock();
    private final Lock rlock =lock.readLock();
    private final Lock wlock =lock.writeLock();

    private int value =0;

    /**
     * 获取写锁
     * @param m
     */
    public void add(int m){
        wlock.lock();
        try {
            value+=m;
        }finally {
            wlock.unlock();
        }
    }
    public void dec(int m){
        wlock.lock();
        try {
            value-=m;
        }finally {
            wlock.unlock();
        }
    }

    //获取读锁
    public int get(){
        rlock.lock();
        try {
            return value;
        }finally {
            rlock.unlock();
        }
    }
}


public class Test07 {

    private static final int L = 1000;

    public static void main(String[] args) throws InterruptedException {
       final Couter couter=new Couter();
       Thread t1=new Thread(){
           public void run(){
               for (int i=0;i<L;i++){
                   couter.add(1);
               }
           }
       };
       Thread t2=new Thread(){
           public void run(){
               for (int i=0;i<L;i++){
                   couter.dec(1);
               }
           }
       };

       t1.start();
       t2.start();
       t1.join();
       t2.join();
       System.out.println(couter.get());
    }

}
