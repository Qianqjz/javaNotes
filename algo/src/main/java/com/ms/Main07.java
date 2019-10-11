package com.ms;

import java.util.Scanner;

public class Main07 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            Float f=scanner.nextFloat();
            int i=(int)(f*10+5)/10;
            System.out.println(i);
        }
    }
}
