package com.ms;

import java.util.Scanner;

public class Main103 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String input=scan.nextLine().trim();
            System.out.println(getResult(input));

        }
    }

    private static String getResult(String s) {
        char[] chs=s.toCharArray();
        int[]  num=new int[200];
        for(int c:chs){
            int i=(int)c;
            num[i]++;
        }
        int max=0;
        for(int i=0;i<num.length;i++){
            if(max<num[i]){
                max=num[i];
                break;
            }
        }
        StringBuilder builder=new StringBuilder();
        while(max!=0){
            for(int i=0;i<num.length;i++){
                if (max==num[i]){
                    builder.append((char)i);
                }
            }
            max--;
        }
        return builder.toString();
    }
}
