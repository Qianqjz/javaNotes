package com.ms;

import java.util.Scanner;

public class Main49 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            int m=scan.nextInt();
            System.out.println(getResult(m));
        }
    }

    private static String getResult(int m) {
        //计算出最小的数
        int min=m*m-(m-1);
        //计算出最大的数
        int max=m*m+(m-1);
        StringBuilder builder=new StringBuilder();

        while(min<=max){
            builder.append(min).append("+");
            min+=2;
        }
//        for(int i=min;i<=max;i++){
//            builder.append(i).append("+");
//        }
        return builder.substring(0, builder.length() - 1);
    }

}
