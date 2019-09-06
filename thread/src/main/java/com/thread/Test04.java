package com.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用callable来实现线程池
 *
 */
class CallImpl implements Callable{

    public Object call() throws Exception {
        for (int i=0;i<10;i++){
            System.out.println("输出结果 :" + i);
        }
        return null;
    }
}

public class Test04 {

    public static void main(String[] args) {

        ExecutorService executorService= Executors.newFixedThreadPool(5);
        CallImpl call=new CallImpl();
        executorService.submit(call);

    }
}
