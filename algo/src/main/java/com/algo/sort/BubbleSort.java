package com.algo.sort;


import com.algo.utils.Untils;

/**
 *  1 冒泡排序
 * @author carl
 *
 */
class ArrayBub{

    private long[] a;
    private int nElems;

    public ArrayBub(int max) {
        a = new long[max];
        nElems = 0;
    }
    public void insert(long value) {
        a[nElems]=value;
        nElems++;
    }
    public void display() {
        for(int i=0;i<nElems;i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println("");
    }
    public void bubbleSort() {
        int out;
        int in;
        for(out=nElems-1;out>0;out--) {
            for(in=0;in<out;in++) {
                if(a[in]>a[out]) {
                    swap(in,out);
                }
            }
        }
    }
    public void swap(int in,int out) {
        long temp=a[in];
        a[in]=a[out];
        a[out]=temp;
    }
}

/**
 * 优化类的冒泡排序
 */
class BubbleSort01 {

    public int[] sort(int[] arr) throws Exception {

        for (int i = 1; i < arr.length; i++) {
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }

            if (flag) {
                break;
            }
        }
        return arr;
    }

}



public class BubbleSort {
    public static void main(String[] args) throws Exception {

        int maxSize=100;
        ArrayBub arr=new ArrayBub(maxSize);

        arr.insert(100);
        arr.insert(109);
        arr.insert(13);
        arr.insert(30);
        arr.insert(160);
        arr.insert(440);

        arr.bubbleSort();
        arr.display();


        /*********************/
        BubbleSort01 bubbleSort01=new BubbleSort01();

        bubbleSort01.sort(Untils.arr);
        Untils.printArr(Untils.arr);
    }
}

