package com.ms;

import java.util.Scanner;

public class Main109 {
    private static int getResult(int m,int n){
        if(n>m){
            int temp=m;
            m=n;
            n=temp;
        }
        // 15 12
        // m=12 n=15
        while(n!=0){
            int k=m%n;
            m=n;
            n=k;
        }
        return m;
    }
    private static int getResult1(int max,int min){
        if(min>max){
            int temp=min;
            max=min;
            min=temp;
        }
        // 15 12
        // m=12 n=15
        while(max % min !=0){
            int k=max%min;
            max=min;
            min=k;
        }
        return min;
    }


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int n=scan.nextInt();
            int m=scan.nextInt();
            System.out.println(12%15);
            System.out.println(getResult(m,n));
            System.out.println(m*n/getResult(n,m));
            System.out.println(m/getResult1(n,m)*n);
        }
    }
}


