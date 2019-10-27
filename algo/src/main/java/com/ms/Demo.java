package com.ms;

import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            String passWord=s.nextLine().trim();
            System.out.println(checkVolate(passWord));
        }
    }

    private static String checkVolate(String str) {
        final String NG="NG";
        final String OK="OK";

        if(str ==null&&str.length()<1){
            return NG;
        }

        int[] kind={0,0,0,0};

        for (int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(c >='a' && c<='z'){
                kind[0]=1;
            }else if(c >='A' && c<= 'Z'){
                kind[1]=1;
            }else if(c >= '0' && c <='9' ){
                kind[2]= 1;
            }else {
                kind[3] =1;
            }
        }

        if(kind[0]+kind[1]+kind[2]+kind[3]<3){
            return NG;
        }

        for(int i=0;i<str.length()-3;i++){
            String first=str.substring(i,i+3);
            String second=str.substring(i+3);
            if(!second.contains(first)){
                return NG;
            }
        }
        return OK;
    }
}
