package com.ms;

import java.util.Scanner;

public class Main17 {
    private static String passwordValidate(String input){
        final String OK="OK";
        final String NG="NG";

        if(input==null||input.length()<9){
            return NG;
        }
        int[] kind ={0,0,0,0};
        //统计
        for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            if(ch>='A'&&ch<='Z'){
                kind[0] = 1;
            }else if(ch>='a'&&ch<='z'){
                kind[1] = 1;
            }else if(ch>='0'&&ch<='9') {
                kind[2] = 1;
            }else {
                kind[3] = 1;
            }
        }
        if(kind[0]+kind[1]+kind[2]+kind[3]<3){
            return NG;
        }

        for (int i = 0; i < input.length() - 3; i++) {
            String s1 = input.substring(i, i + 3);
            String s2 = input.substring(i + 3, input.length());
            if (s2.contains(s1)) {
                return NG;
            }
        }
        return OK;
    }

    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String input=scan.nextLine();
            String s = passwordValidate(input);
            System.out.println(s);

        }


    }
}

