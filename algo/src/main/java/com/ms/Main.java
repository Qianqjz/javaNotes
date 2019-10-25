package com.ms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while(s.hasNext()){
            String input=s.nextLine().trim();
            StringBuilder builder=new StringBuilder();
//            splitStr(builder,input);
//            splitInput(builder,input);
            getResult(input);
//            System.out.println(builder);
        }
    }

    private static  void  getResult(String s){
        while(s.length()>8){
            System.out.println(s.substring(0,8));
            s=s.substring(8);
        }
        if(s.length()>0&&s.length()<=8){
            s=s+"00000000";
            System.out.println(s.substring(0,8));
        }
    }

    private static void splitInput(StringBuilder builder,String input){
        while(input.length()>=8){
            builder.append(input.substring(0,8)).append("\n");
            input=input.substring(8);
        }
        if(input.length()<=8&&input.length()>0){
            String s=input+"00000000";
            builder.append(s.substring(0,8)).append("\n");
        }
    }


    private static void splitStr(StringBuilder builder,String input) {
        if (input==null&&input.length()<1){
            return ;
        }
        int pos=0;

        if((pos+=8)<=input.length()){
            builder.append(input.substring(pos,pos+8)).append("\n");
        }

        if((pos>=input.length())){
            builder.append(builder.substring(pos-8,input.length()));
            for(int i=input.length();i<=pos;i++){
                builder.append("0");
            }
            builder.append("\n");
        }
    }
}
