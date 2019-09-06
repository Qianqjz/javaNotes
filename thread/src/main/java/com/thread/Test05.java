package com.thread;

import java.util.concurrent.*;

/**
 * 通过线程池计算结果
 *
 * 使用future获取异步的结果
 * 阻塞get()
 * 轮询isDone（）
 *
 * 这两个方法都不是太好，可以使用CompletableFuture，
 *
 * 异步任务结束时，会自动回调某个对象的方法
 * 异步任务出错时，会自动回调某个对象的方法
 * 主线程设置好回调后，不在关系异步任务的执行
 *
 *
 */
class MyCallable implements Callable<Integer>{

    int x= 2;
    int y= 3;

    public MyCallable() {
    }

    public MyCallable(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Integer call() throws Exception {
        return x+y;
    }
}

public class Test05 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService= Executors.newFixedThreadPool(5);

        MyCallable myCallable01=new MyCallable(100,200);
        MyCallable myCallable02=new MyCallable(10,20);

        Future<Integer> submit = executorService.submit(myCallable01);
        Integer integer = submit.get();
        System.out.println("计算第一次结果 : "+integer);

        Future<Integer> submit1 = executorService.submit(myCallable02);
        integer = submit1.get();
        System.out.println("计算第二次结果 : "+integer);

    }
}
