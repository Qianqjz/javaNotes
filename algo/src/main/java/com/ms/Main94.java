package com.ms;

import java.util.Scanner;

public class Main94 {

    private final static String WORDS[] = {
            "", "one", "two", "three", "four", "five",// 1-5
            "six", "seven", "eight", "nine", "ten",// 6-10
            "eleven", "twelve", "thirteen", "fourteen", "fifteen",// 11-15
            "sixteen", "seventeen", "eighteen", "nineteen", "twenty",// 16-20
            "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"// 30-90
    };


    public static void main(String[] args) {
        String[] WORDS={"","","","","",""};

        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            long n = scan.nextLong();
            System.out.println(parse(n));
        }
    }

    private static String parse(long num) {
        if (num <= 0) {
            return "error";
        } else if (num < 20) {  // 20以下
            return WORDS[(int) num];
        } else if (num < 100) {
            if (num % 10 == 0) {
                return WORDS[(int) (20 + (num - 20) / 10)];     // 20 30 40 50 60 70 80 90
            } else {
                return parse(num / 10 * 10) + " " + parse(num % 10);
            }
        } else if (num < 1000) { // 千以下
            if (num % 100 == 0) {
                return parse(num / 100) + " hundred";
            } else {
                return parse(num / 100) + " hundred and " + parse(num % 100);
            }
        } else if (num < 1000000) { // 百万以下
            if (num % 1000 == 0) {
                return parse(num / 1000) + " thousand";
            } else {
                return parse(num / 1000) + " thousand " + parse(num % 1000);
            }
        } else if (num < 1000000000) { // 亿
            if (num % 1000000 == 0) {
                return parse(num / 1000000) + " million";
            } else {
                return parse(num / 1000000) + " million " + parse(num % 1000000);
            }
        } else if (num < 10000000000L) { // 十亿
            if (num % 1000000000 == 0) {
                return parse(num / 1000000000) + " billion";
            } else {
                return parse(num / 1000000000) + " billion " + parse(num % 1000000000);
            }
        } else {
            return "error";
        }
    }


}
