package com.ms;


import java.util.Scanner;

/**
 * hello world
 */

public class Main32 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int m=0;
            int j=0;
            int k=0;
            int l=0;
            String input=scan.nextLine().trim();
            char[] arr=input.toCharArray();
            for(int i=0;i<input.length();i++){
                char c=arr[i];
                if((c>='a'&&c<='z')||(c>='A'&&c<='Z')){
                    m+=1;
                }else if(c==' '){
                    j+=1;
                }else if(c>='0'&&c<='9'){
                    k+=1;
                }else{
                    l+=1;
                }
            }
            System.out.println(m);
            System.out.println(j);
            System.out.println(k);
            System.out.println(l);
        }
    }
}


