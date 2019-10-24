package com.ms;

import java.util.Scanner;

//        157/7  22
//        157%7  3
//
//        分子减余数  7-3   新的分子4
//        新分母= 分母*(商+1) 157*(22+1)
//
//
//        7/157 =   1/23+4/157*23;
//
//        7*23/157*23 = 157/157*23+ 4/157*23;
public class Main101 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
           String input=scan.nextLine();
            System.out.println(covert(input));
        }
    }

    private static String covert(String input) {
        String[] arr=input.split("/");

        //分子
        int fz=Integer.parseInt(arr[0]);
        //分母
        int fm=Integer.parseInt(arr[1]);

        StringBuilder builder=new StringBuilder();
        while(fm%fz!=0){
            //商
            int sh=fm/fz;
            //余数
            int ys=fm%fz;
            builder.append(1).append("/").append(sh+1).append("+");

            fz=fz-ys;
            fm=fm*(sh+1);
        }
        builder.append(1).append("/").append(fm/fz);
        return builder.toString();
    }
}
