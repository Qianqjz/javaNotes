package com.ms;

import java.util.Scanner;

public class Main45 {
    private static int calculate(int year,int month,int day){
        int[] dayOfMonth={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(year%4==0&&year%100!=0||year%400==0){
            dayOfMonth[1]=29;
        }
        if(month<1||month>12||day<1||day>dayOfMonth[month-1]){
            return -1;
        }
        for(int i=0;i<month-1;i++){
            day+=dayOfMonth[i];
        }
        return day;

    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int year=scan.nextInt();
            int month=scan.nextInt();
            int day=scan.nextInt();

            System.out.println(calculate(year,month,day));

        }


    }
}

