package com.ms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main55 {
    private static boolean getBolle(String min, String max) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < min.length(); i++) {
            set.add(min.charAt(i));
        }
        for (int i = 0; i < max.length(); i++) {
            if (!set.contains(max.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String min = scan.nextLine();
            String max = scan.nextLine();
            System.out.println(getBolle(min, max));
        }
    }
}
