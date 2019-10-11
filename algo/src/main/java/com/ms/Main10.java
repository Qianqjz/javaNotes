package com.ms;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()) {
            String str=scan.nextLine().trim();
            int[] arr=new int[127];
            for(int i=0;i<str.length();i++){
                char c=str.charAt(i);
                arr[c]++;
            }
            long sum=0;
            for(int s:arr){
                if(s!=0)
                sum+=1;
            }
            System.out.println(sum);
        }
    }
}

