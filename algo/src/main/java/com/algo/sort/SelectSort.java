package com.algo.sort;


import com.algo.utils.Untils;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

/**
 *  2 选择排序
 * @author carl
 *
 */
class ArraySel{

    private long[] a;
    private int nElems;

    public ArraySel(int max) {
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
    }
    public void SelectSort() {
        int out;
        int min;
        int in;
        for(out=0;out<nElems-1;out++) {
            min = out;
            for(in=out+1;in<nElems;in++) {
                if(a[in]<a[min]) {
                    min = in;
                }
            }
            swap(out,min);
        }
    }
    public void swap(int in,int out) {
        long temp=a[in];
        a[in]=a[out];
        a[out]=temp;
    }
}

/**
 *
 * 选择排序，是从第一个元素开始比较，找出之后的元素中最小的，和第一个元素比较，如果第一
 * 个元素大于剩下元素中最小的，则将二者交换顺序。以此类推。
 *
 * 参考菜鸟网。
 */
class SelectionSort  {

    public int[] sort(int[] arr) throws Exception {

        // 总共要经过 N-1 轮比较
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            // 每轮需要比较的次数 N-i
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    // 记录目前能找到的最小值元素的下标
                    min = j;
                }
            }

            // 将找到的最小值和i位置所在的值进行交换
            if (i != min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }

        }
        return arr;
    }
}


public class SelectSort {
    public static void main(String[] args) throws Exception {

        int maxSize=100;
        ArraySel arr=new ArraySel(maxSize);

        arr.insert(100);
        arr.insert(109);
        arr.insert(13);
        arr.insert(30);
        arr.insert(160);
        arr.insert(440);

        arr.SelectSort();
        arr.display();
        System.out.println();

        /*********************/
        SelectionSort selectionSort=new SelectionSort();

        selectionSort.sort(Untils.arr);
        Untils.printArr(Untils.arr);


    }
}
