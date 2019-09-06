package com.thread;

import java.util.LinkedList;
import java.util.Queue;

/**
 * wait() 只针对的是当前线程 在wait()方法执行时，对象的锁会释放掉
 * notifyall()
 * 用于多线程的协调执行
 *
 * 在synchronized 内部可以调用 wait()使线程进入等待状态
 * 必须在已经获取锁的对象上使用wait()
 * 在synchronized 内部可以调用 notifyall()/notify()使线程进入等待状态
 * 必须在已经获取锁的对象上使用notifyall()/notify()
 *
 * 下面的例子是一个队列，一边往队列里面放任务，一边在消费
 */
class TaskQueue{
    final Queue<String> queue=new LinkedList<String>();

    public synchronized  String getTask() throws InterruptedException {
        while (this.queue.isEmpty()){
            this.wait();
        }
        return queue.remove();
    }

    public synchronized void addTask(String name){
        this.queue.add(name);
        this.notifyAll();
    }
}

class WorkThread extends Thread{

    TaskQueue queue;

    public WorkThread(TaskQueue taskQueue){
        this.queue=taskQueue;
    }

    @Override
    public void run() {
        while (!isInterrupted()){
            String name;
            try {
                name=queue.getTask();
            }catch (InterruptedException e){
                break;
            }
            String result ="Hello ,"+name+".";
            System.out.println(result);
        }
    }
}

public class Test02 {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue queue=new TaskQueue();
        WorkThread thread=new WorkThread(queue);
        thread.start();

        queue.addTask("bob");
        Thread.sleep(1000);
        queue.addTask("alice");
        Thread.sleep(1000);
        queue.addTask("tom");
        Thread.sleep(1000);
        thread.interrupt();
        thread.join();
        System.out.println("END");



    }

}
