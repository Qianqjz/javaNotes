package com.ms;

import java.util.Scanner;

public class Main21 {

    private static int bottle(int num){
        final int BASE=3;
        if(num<BASE-1){
            return 0;
        }
        int result=0;
        while(num>BASE-1){
            //本次喝的饮料数
            int drink=num/BASE;
            //总共喝的饮料数
            result+=drink;
            //手上的瓶子
            num=num%BASE+drink;
        }

        if(num==BASE-1){
            result++;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        int num;
        while(scan.hasNextInt()){
            num=scan.nextInt();
            if(num==0){
                return;
            }
            System.out.println(bottle(num));

        }


    }
}

