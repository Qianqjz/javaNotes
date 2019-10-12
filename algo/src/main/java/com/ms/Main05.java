package com.ms;

import java.util.Scanner;

/**
 * 0x2AF5
 */

public class Main05 {

//    private static int hexToDec(String hex) {
//        final int BASE = 16;
//        int result = 0;
//
//        for (int i = 2; i < hex.length(); i++) {
//            result = result * BASE + hexToNum(hex.charAt(i));
//        }
//        return result;
//    }
//
//    private static int hexToNum(char ch) {
//
//        if (ch >= '0' && ch <= '9') {
//            return ch - '0';
//        } else if (ch >= 'a' && ch <= 'z') {
//            return ch - 'a' + 10;
//        } else {
//            return ch - 'A' + 10;
//        }
//    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String input=scanner.nextLine().trim();
            System.out.println(hexToDec(input));
        }
        scanner.close();
    }

    private static int hexToDec(String input){
        final int BASE=16;
        int result = 0;
        for(int i=2;i<input.length();i++){
            result=result*BASE+num(input.charAt(i));
        }
        return result;
    }

    private static int num(char c){
        if (c >='0'&&c<='9'){
            return c - '0';
        } else if(c >='A'&&c<='Z'){
            return c - 'A' +10;
        }else {
            return c - 'a' +10;
        }
    }
}
