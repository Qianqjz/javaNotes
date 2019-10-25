package com.ms;

import java.util.Scanner;

public class Main88 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String input=scan.nextLine().trim();
            int n=scan.nextInt();
            System.out.println(getResult(input,n));

        }
    }

    private static String getResult(String s, int n) {
        StringBuilder builder=new StringBuilder();
        for(int i=0,sum=0;i<s.length();i++){
            if(String.valueOf(s.charAt(i)).getBytes().length==1){
                sum+=1;
                builder.append(s.charAt(i));
                if(sum>n){
                    break;
                }

            }else {
                sum+=2;
                if(sum>n){
                    break;
                }
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
