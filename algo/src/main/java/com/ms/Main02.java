package com.ms;

import java.util.Scanner;

public class Main02 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        String word = sc.nextLine();
        int count=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.substring(i,i+1).equalsIgnoreCase(word))
            {
                count++;
            }
        }
        System.out.println(count);
    }
}


