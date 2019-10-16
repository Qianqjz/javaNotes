package com.ms;

import java.util.Scanner;

class Main105 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
           int n=scan.nextInt();
           for(int i=0;i<n;i++){
               String input = scan.nextLine();
               if (input== null && input.length()<1){
                   continue;
               }
               StringBuilder builder=new StringBuilder(input);
               if (builder.length()%8!=0){
                   int more=8-builder.length()%8;
                   for (int j=0;j<more;j++){
                       builder.append("0");
                   }
               }
               for (int k=0;k<input.length();k+=8){
                   System.out.println(builder.substring(k,k+8));
               }
           }
        }
    }
}





