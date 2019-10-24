package com.ms;

import java.util.Scanner;

public class Main126 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            System.out.print(getResult(n));

        }

    }

    private static String getResult(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1, start = (i - 1) * i / 2 + 1, step = i + 1; j <= n - i + 1; j++, start += step, step++) {

                builder.append(start).append(' ');
            }
            builder.setCharAt(builder.length() - 1, '\n');
        }

        return builder.toString();
    }
}



