package com.ms;

import org.junit.Test;

public class Demo {
    private static void getResult(int[] arr,int left,int right){
        int index =0;
        if(left<right){
            index =union(arr,left,right);
            getResult(arr,left,index-1);
            getResult(arr,index+1,right);
        }

    }

    private static int union(int[] arr, int left, int right) {
        int key = arr[left];
        while(left<right) {
            while(left<right&&arr[right]>=key){
                right--;
            }
            arr[right]=arr[left];
            while(left<right&&arr[left]<=key) {
                left++;
            }
            arr[left]=arr[right];
        }
        arr[left]=key;
        return left;
    }

    public static void main(String[] args) {

    }

    private static String getRes(long n){
        StringBuilder builder=new StringBuilder();
        int i=2;
        while(i<=n){
            while(n%i==0){
                builder.append(i).append(' ');
                n/=i;
            }
            i++;
        }
        return builder.toString();
    }

    @Test
    public void test01(){
        System.out.println(getRes1res(20));
    }

    private static String getRes1res(int n){
        StringBuilder builder=new StringBuilder();
        for(int i=1;i<=n;i++){
            for(int j=1,start=(i-1)*i/2+1,step=i+1;j<n-i+1;j++,start+=step,step++){
                builder.append(start).append(' ');
            }
            builder.setCharAt(builder.length()-1,'\n');
        }
        return builder.toString();
    }
}

