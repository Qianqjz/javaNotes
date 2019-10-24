package com.ms;

import java.util.Scanner;

class Main106 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String input=scan.nextLine();
            String[] arr=input.split("\\s");
            int fnum=0;
            int znum=0;
            int zsum=0;
            for(int i=0;i<arr.length;i++){
                int s=Integer.valueOf(arr[i]);
                if(s<0){
                    fnum++;
                }else {
                    znum++;
                    zsum+=s;
                }
            }
            System.out.print(fnum);
            System.out.printf("%.1f",(float)zsum/znum);
        }
    }
}





