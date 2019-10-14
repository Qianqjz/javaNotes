package com.ms;

import java.util.Scanner;
public class Main20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            char[] inchar = input.toCharArray();
            for (int i = 0; i < inchar.length; i++) {
                if (inchar[i] >= 'a' && inchar[i] <= 'c') {
                    inchar[i] = '2';
                } else if (inchar[i] >= 'd' && inchar[i] <= 'f') {
                    inchar[i] = '3';
                } else if (inchar[i] >= 'g' && inchar[i] <= 'i') {
                    inchar[i] = '4';
                } else if (inchar[i] >= 'j' && inchar[i] <= 'l') {
                    inchar[i] = '5';
                } else if (inchar[i] >= 'm' && inchar[i] <= 'o') {
                    inchar[i] = '6';
                } else if (inchar[i] >= 'p' && inchar[i] <= 's') {
                    inchar[i] = '7';
                } else if (inchar[i] >= 't' && inchar[i] <= 'v') {
                    inchar[i] = '8';
                } else if (inchar[i] >= 'w' && inchar[i] <= 'z') {
                    inchar[i] = '9';
                } else if (inchar[i] >= 'A' && inchar[i] < 'Z') {
                    inchar[i] = (char) (inchar[i] + 33);
                } else if (inchar[i] == 'Z') {
                    inchar[i] = 'a';
                }
            }
            System.out.println(String.valueOf(inchar));
        }
    }
}


