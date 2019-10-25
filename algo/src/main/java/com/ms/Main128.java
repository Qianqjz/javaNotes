package com.ms;

import java.util.Scanner;

public class Main128 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            getOneNumber(n);

        }

    }

    private static void getOneNumber(int n) {
        char[] chs=Integer.toBinaryString(n).toCharArray();
        int count =0;
        for (int i=0;i<chs.length;){
            while(i<chs.length&&chs[i]!='1'){
                i++;
            }

            int j=i;
            while(j<chs.length&&chs[j]=='1'){
                j++;
                if((j-i)>count){
                    count=j-i;
                }
            }
            i=j;
        }
        System.out.println(count);
    }

}

