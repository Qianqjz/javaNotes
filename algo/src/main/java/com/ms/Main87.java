package com.ms;

import java.util.Scanner;

public class Main87 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String line;
        while(scan.hasNextLine()){
            line =  scan.nextLine().trim();
            System.out.println(getResult(line));

        }
    }

    private static String getResult(String s) {

        int cur=0;
        int max=0;
        String result="";
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c>='0'&&c<='9'){
                cur++;
                if(max<cur){
                    max=cur;
                    result=s.substring(i-max+1,i+1);
                }else if (max==cur){
                    result+=s.substring(i-max+1,i+1);
                }
            }else {
                cur=0;
            }
        }
        return result+" "+max;
    }
}
