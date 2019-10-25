package com.ms;

import java.util.Scanner;

public class Main110 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()) {
            int n=scan.nextInt();
            System.out.println(count(n));

        }
    }

    private static int count(int n) {

        int result=0;
        for(int i = 2;i<n;i++){

            int sum = 1;
            for(int j = 2;j<=i/2;j++){
                if(i%j==0){
                  sum+=j;
                }
            }
            if(sum==i){
                result++;
            }
        }

        return result;
    }


}
