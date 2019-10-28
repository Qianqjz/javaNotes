package com.ms;

import java.util.*;

public class Demo {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String str = s.nextLine().trim();
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < 26; j++) {
                for (int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (c == (j + 'a') || c == (j + 'A')) {
                        builder.append(c);
                    }
                }
            }
            int k = 1;
            StringBuilder bu = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (!isLetter(ch)) {
                    bu.append(ch);
                } else {
                    bu.append(builder.charAt(k));
                    k++;
                }
            }
            System.out.println(bu.toString());
        }
    }

    private static boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

}
