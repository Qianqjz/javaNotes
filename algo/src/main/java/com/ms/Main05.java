package com.ms;

import java.util.Scanner;

/**
 * 0x2AF5
 */

public class Main05 {

    private static int hexToDec(String hex) {
        final int BASE = 16;
        int result = 0;

        for (int i = 2; i < hex.length(); i++) {
            result = result * BASE + hexToNum(hex.charAt(i));
        }
        return result;
    }

    private static int hexToNum(char ch) {

        if (ch >= '0' && ch <= '9') {
            return ch - '0';
        } else if (ch >= 'a' && ch <= 'z') {
            return ch - 'a' + 10;
        } else {
            return ch - 'A' + 10;
        }
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            String input=scanner.nextLine().trim();
            System.out.println(hexToDec(input));
        }
        scanner.close();
    }
}
