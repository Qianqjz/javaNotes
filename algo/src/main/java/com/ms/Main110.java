package com.ms;


import java.util.Scanner;

public class Main110 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNextLine()){
            int m=scan.nextInt();
            int n=scan.nextInt();
            System.out.println(m/getResult(m,n)*n);

        }
    }

    private static int getResult(int max, int min) {
        if (max<min){
            int t=max;
            max=min;
            min=t;
        }
        while(max%min!=0){
            int k=max%min;
            max=k;
            min=max;
        }
        System.out.println("min :"+min);
        System.out.println("max :"+max);
        return min;
    }
}


