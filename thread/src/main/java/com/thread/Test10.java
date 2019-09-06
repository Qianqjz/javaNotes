package com.thread;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * forkjoin
 *
 * 将大任务 拆分成小任务 小任务之间并行执行
 *
 * 分治的算法
 * 分解任务+合并结果
 *
 * 必须继承recursiveTask （有返回值）/recursiveAction（没有返回值）方法；
 *
 */

class SumTask extends RecursiveTask<Long>{

    private static final int THRESHOLD=250;
    long[] array;
    int start;
    int end;

    public SumTask(long[] array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    protected Long compute() {
        if (end - start<THRESHOLD){
            //如果任务足够小，直接计算
            long sum= 0 ;
            for (int i=start ;i<end;i++){
                sum+=i;
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return sum;
        }
        //如果任务太大，就一分为二
        int middle =(end+start)>>1;
        System.out.println(String.format("split %d~%d ==> %d~%d ,%d~%d",start, end, start, middle, middle, end));
        SumTask sumTask1=new SumTask(this.array,start,middle);
        SumTask sumTask2=new SumTask(this.array,middle,end);
        invokeAll(sumTask1,sumTask2);
        Long res1=sumTask1.join();
        Long res2=sumTask1.join();
        Long result=res1+res2;
        System.out.println("res1 : "+res1+", res2 : "+res2);
        return result;
    }
}

public class Test10 {
    static Random random=new Random(10);

    static long random(){
       return random.nextInt(10000);
    }

    public static void main(String[] args) {
        //创建一个1000个元素的数组
        long[] array=new long[1000];
        long expectedSum = 0;
        for (int i=0;i<array.length;i++){
            array[i]= random();
            expectedSum+=array[i];
        }
        System.out.println("expectedSum : "+expectedSum);
        ForkJoinTask<Long> task=new SumTask(array,0,array.length);
        long startTime=System.currentTimeMillis();
        long result= ForkJoinPool.commonPool().invoke(task);
        long endTime=System.currentTimeMillis();

        System.out.println("forkjoin sum:"+result+" in "+(endTime-startTime)+".ms");
    }




}
