package com.algo.sort;

import java.util.Arrays;

/**
 * 快速排序
 *   12,3,56,23,14,87,69,100,234,2,35
 * 1，先去key=arr[left]  12
 *    和arr[right] 数组中最末尾的数值比较
 *
 *   key=12
 *
 *    12,   3,  56, 23, 14, 87, 69, 100, 234, 2, 35
 *                                            12
 *    35 大于12 ，继续执行下一个
 *    12,   3,  56, 23, 14, 87, 69, 100, 234, 2, 35
 *                                            12
 *    12 大于2 将12与2 进行位置互换
 *
 *    2,   3,  56, 23, 14, 87, 69, 100, 234, key, 35
 *         12
 *    将12 与3进行比较 12 大于3 继续 比较
 *
 *    2,   3,  56, 23, 14, 87, 69, 100, 234, key, 35
 *             12
 *    12 小于 56 将56 与key位置调换
 *
 *    2,   3,  key, 23, 14, 87, 69, 100, 234, 56, 35
 *                                       12
 *    将12与234 比较，调换位置，以此进行比较。
 *
 */
public class QuickSort {

    /**
     * 递归算法
     * @param arr
     * @param left
     * @param right
     */
    public static void pair(int[] arr,int left,int right){

        int index = 0;
        if (left<right){
           index = unit(arr,left,right);
           pair(arr,left,index-1);
           pair(arr,index+1,right);
        }
    }

    /**
     * 获取比较后的最小值
     * @param arr
     * @param left
     * @param right
     * @return
     */
    private static int unit(int[] arr, int left, int right) {

        int key =arr[left];

        while (left < right) {

            while (left < right && arr[right] >= key) {
                right--;
            }
            arr[left]=arr[right];

            while (left < right && arr[left] <= key) {
                left++;
            }
            arr[right]=arr[left];
        }
        arr[left] = key;
        return left;
    }

    /**
     *  排序结果：
     *  befor sort:[12, 3, 56, 23, 14, 87, 69, 100, 234, 2, 35]
     *  after sort:[2, 3, 12, 14, 23, 35, 56, 69, 87, 100, 234]
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] arr={12,3,56,23,14,87,69,100,234,2,35};
        System.out.println(" befor sort:"+ Arrays.toString(arr));
        pair(arr,0,arr.length-1);
        System.out.println(" after sort:"+ Arrays.toString(arr));
    }
}
