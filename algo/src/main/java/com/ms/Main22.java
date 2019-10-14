package com.ms;

import java.util.Arrays;
import java.util.Scanner;

public class Main22 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();
            int[] state = new int[26];
            int[] sort = new int[26];
            for (int i = 0; i < line.length(); i++) {
                state[line.charAt(i) - 'a']++;
                sort[line.charAt(i) - 'a']++;
            }
            Arrays.sort(sort);
            int num = 0;
            for (int i = 0; i < sort.length; i++) {
                if (sort[i] != 0) {
                    num = sort[i];
                    break;
                }
            }
            for (int i = 0; i < line.length(); i++) {
                if (state[line.charAt(i) - 'a'] != num) {
                    System.out.print(line.charAt(i));
                }
            }
            System.out.println();
        }
    }
}


