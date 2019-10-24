package com.ms;

import java.util.Scanner;

public class Main112 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n=scan.nextInt();
            int result=0;
            for(int i=1;i<=n;i++){
                if(i%7==0){
                    result++;
//                    System.out.println(i+":"+result);
                }else {
                    String str=i+"";
                    if(str.contains("7")){
                        result++;
//                        System.out.println(i+":"+result);
                    }
                }
            }
            System.out.println(result);

        }
    }
}

