package com.ms;

import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            int num = scanner.nextInt();
            System.out.println(reverseNumber(num));
        }

        scanner.close();
    }

    private static String reverseNumber(int num) {
        StringBuilder builder = new StringBuilder();

        do {
            builder.append(num % 10);
            num /= 10;
        } while (num != 0);


        return builder.toString();
    }
}

