package com.ms;

import java.util.Scanner;

public class Main1000 {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        while (s.hasNext()){
            int n=s.nextInt();
            System.out.println(getResult(n));
        }
    }

    private static String getResult(int n) {
        StringBuffer buffer=new StringBuffer();
        for (int i=1;i<=n;i++){
            for(int j=1,start=(i-1)*i/2+1,step=i+1;j<n-i+1;j++,start+=step,step++){
                buffer.append(start).append(' ');
            }
            buffer.setCharAt(buffer.length()-1,'\n');
        }
        return buffer.toString();
    }
}
