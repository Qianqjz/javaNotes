package com.ms;

import java.util.Scanner;

public class Main129 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String input=scan.nextLine().trim();
            int n=scan.nextInt();
            int index=0;
            int maxRadio=0;
            for (int i=0;i<input.length();i++){
                int temp=getMaxRadio(input.substring(i,i+n));
                if (temp>maxRadio){
                    maxRadio=temp;
                    index=i;
                }
            }
            System.out.println(input.substring(index,index+n));
        }
    }

    private static int getMaxRadio(String substring) {
        int count=0;
        for (int i=0;i<substring.length();i++){
            if('G'==substring.charAt(i)||'C'==substring.charAt(i)){
                count++;
            }
        }
        return count;
    }
}
