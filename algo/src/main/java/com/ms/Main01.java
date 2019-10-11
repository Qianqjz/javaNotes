package com.ms;


import java.util.Scanner;

/**
 * hello world
 */

public class Main01{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String line;
        while(scan.hasNextLine()){
            line =  scan.nextLine().trim();
            String[] array = line.split(" ");
            int lastNumber = array[array.length-1].length();
            System.out.println( array[array.length-1].length());
        }
    }
}


