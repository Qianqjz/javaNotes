package com.ms;

import java.util.Arrays;
import java.util.Scanner;

class Main107 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String input=scan.nextLine();
            StringBuilder builder=new StringBuilder(input);
            builder.reverse();
            System.out.println(builder);
        }
    }
}





