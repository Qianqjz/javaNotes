package com.ms;

import java.util.Scanner;

public class Main104 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n=scan.nextInt();
            String [] data=scan.nextLine().trim().split(" ");
            int[] arr=new int[n];
            //将传入的字符串数字转化为整数存储
            for(int i=0;i<data.length;i++){
                arr[i]=Integer.parseInt(data[i]);
            }

            int[] brr=new int[n];
            for(int i=0;i <arr.length;i++){
                brr[i]=1;
                for(int j=0;j<i;j++){
                    if(arr[i]>arr[j]){
                        brr[i]=Math.max(brr[i],brr[j]+1);
                    }
                }
            }
            int max=0;
            for(int i=0;i<brr.length;i++){
                if(max<brr[i]){
                    max=brr[i];
                }
            }
            System.out.println(max);
        }
    }

}
