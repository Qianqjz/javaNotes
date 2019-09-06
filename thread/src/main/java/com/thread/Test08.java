package com.thread;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized 有wait 和notify notifyall来配合使用，
 *
 *
 * ReentrantLock 可以使用condition中的方法
 * condition.await()方法就相当于wait()方法
 * condition.signalAll() == notifyall()
 *
 * 学习线程池，生产者，消费者队列
 */
class TaskkQueue {

    final Queue<String> queue=new LinkedList();
    final Lock lock=new ReentrantLock();
    final Condition condition= lock.newCondition();

    public void addTaskk(String name) throws InterruptedException {
        lock.lock();
        try {
            queue.add(name);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public String getTaskk() throws InterruptedException {

        lock.lock();
        try {
            while (this.queue.isEmpty()){
                condition.await();
            }
            return queue.remove();
        }finally {
            lock.unlock();
        }
    }
}

class TaskkThread extends Thread{

    TaskkQueue taskkQueue;

    public TaskkThread() {
    }

    public TaskkThread(TaskkQueue taskkQueue) {
        this.taskkQueue = taskkQueue;
    }

    @Override
    public void run() {

        while (!isInterrupted()){
            String name ;
            try {
                name = this.taskkQueue.getTaskk();
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            System.out.println("hello ："+ name);
        }
    }
}

public class Test08 {

    private static TaskkQueue taskkQueue = new TaskkQueue();
    private static final Thread TaskkThread = new TaskkThread(taskkQueue);;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService executorService= Executors.newFixedThreadPool(2);
        executorService.submit(TaskkThread);
        taskkQueue.addTaskk("tom");
        Thread.sleep(1000);
        taskkQueue.addTaskk("jerry");
        Thread.sleep(1000);
        taskkQueue.addTaskk("alice");
        Thread.sleep(1000);

        System.out.println("END");

        // TaskkThread.start();
        // taskkQueue.addTaskk("tom");
        // Thread.sleep(1000);
        // taskkQueue.addTaskk("jerry");
        // Thread.sleep(1000);
        // taskkQueue.addTaskk("alice");
        // Thread.sleep(1000);
        // TaskkThread.interrupt();
        // TaskkThread.join();
        //
        // System.out.println("END");




    }
}
