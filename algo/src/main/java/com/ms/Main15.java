package com.ms;

import java.util.Scanner;

public class Main15 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int num=scan.nextInt();
            int result=0;
            while(num!=0){
                result +=num&1;
                num >>=1;
            }
            System.out.println(result);
        }
//0101  0010  0001
//0001  0001  0001
//0001  0000  0001

    }

}

