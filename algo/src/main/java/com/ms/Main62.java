package com.ms;

import java.util.Scanner;

public class Main62 {
        public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            String str=s.nextLine().trim();
            StringBuffer b=new StringBuffer();
            int temp=0;
            for (int i=0;i<str.length();i++){
                char c=str.charAt(i);
                if(c>='0' &&c<='9'){
                    if(temp==0) {
                        System.out.print("*");
                        temp = 1;
                    }
                }else {
                    if(temp==1){
                        System.out.print("*");
                        temp=0;
                    }
                }
                System.out.print(c);
            }

            if(str.charAt(str.length()-1)>='0'&&str.charAt(str.length()-1)<='9'){
                System.out.println("*");
            }
        }
    }
}