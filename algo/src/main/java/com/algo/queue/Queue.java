package com.algo.queue;

public class Queue {

    private int maxSize; //最大元素数
    private long[] queArray;//数组
    private int front;//队头
    private int rear; //队尾
    private int nItem; //当前队列重元素的数量

    public Queue(int s) {
        this.maxSize = s;
        queArray =new long[maxSize];
        front=0;
        rear=-1;
        nItem=0;
    }

    //如果rear等于最大数量减去1 说明队列已经满了，返回-1；
    public void insert(long j){
        if (rear==maxSize-1){
            rear=-1;
        }
        queArray[++rear]=j;
        nItem++;
    }

    public long remove(){
        long temp=queArray[front++];
        if (front==maxSize){
            front = 0;
        }
        nItem--;
        return temp;
    }
    //出队列
    public long peekFront(){
        return queArray[front];
    }
    //队列是否为空
    public boolean isEmpty(){
        return nItem==0;
    }
    public boolean isFull() {
        return nItem == maxSize;
    }
    //返回队列中元素的数量
    public int size(){
       return nItem;
    }

    public static void main(String[] args) {

        Queue queue=new Queue(5);
        queue.insert(15);
        queue.insert(58);
        queue.insert(65);
        queue.insert(36);
        queue.insert(78);

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();

        queue.insert(90);
        queue.insert(80);
        queue.insert(70);
        // 78 90 80 70

        while(!queue.isEmpty()){
            long n=queue.remove();
            System.out.println(n);
        }
    }

}
