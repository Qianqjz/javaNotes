package com.ms;

import java.util.Arrays;
import java.util.Scanner;

public class Main118 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String s1 = scan.nextLine();
            char[] arr=s1.toCharArray();
            Arrays.sort(arr);
            StringBuilder builder=new StringBuilder();
            for(char i:arr){
                builder.append(i);
            }
            System.out.println(builder);
        }
    }
}
