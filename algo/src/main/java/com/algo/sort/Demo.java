package com.algo.sort;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        int[] arr={12,3,56,23,14,87,69,100,234,2,35};
        System.out.println(" befor sort:"+ Arrays.toString(arr));
        sortQuick(arr,0,arr.length-1);
        System.out.println(" after sort:"+ Arrays.toString(arr));
    }

    private static void sortQuick(int[] arr, int left, int right) {
        int index = 0 ;
        if(left<right){
            index=union(arr,left,right);
            sortQuick(arr,left,index-1);
            sortQuick(arr,index+1,right);
        }
    }

    private static int union(int[] arr, int left, int right) {
        int key =arr[left];
        while(left<right){
            while(left<right&&arr[right]>=key){
                right--;
            }
            arr[right] =arr[left];
            while(left<right&&arr[left]<=key){
                left++;
            }
            arr[left]=arr[right];
        }
        arr[left]=key ;
        return left;
    }
}
