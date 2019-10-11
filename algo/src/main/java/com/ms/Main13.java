package com.ms;

import java.util.Scanner;

public class Main13 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String str=scan.nextLine().trim();
            String[] arr=str.split(" ");
            StringBuilder builder=new StringBuilder(1024);
            for(int i=arr.length-1;i>=0;i--){
                builder.append(arr[i]).append(" ");
            }
            System.out.println(builder);
        }
    }
}

