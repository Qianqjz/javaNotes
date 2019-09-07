package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用线程池来计算加法运算
 *
 */
class RunableImpl implements Runnable{

    Lock lock=new ReentrantLock();

    public void run() {
        lock.lock();
        try {
            int sum=0;
            for (int i=0;i<10;i++){
                sum+=i;
            }
            System.out.println("sum = "+sum);
        }finally {
            lock.unlock();
        }

    }
}

public class Test03 {

    public static void main(String[] args) {

        ExecutorService executorService= Executors.newFixedThreadPool(2);

        RunableImpl runable=new RunableImpl();

        executorService.submit(runable);
//        executorService.submit(runable);

        executorService.shutdown();

    }
}
