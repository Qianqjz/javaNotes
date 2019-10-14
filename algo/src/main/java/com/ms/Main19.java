package com.ms;


import java.util.Scanner;

public class Main19 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scan.hasNext()) {
            String str = scan.nextLine();
            for (char ch : str.toCharArray()) {
                if (!(ch >= 'a' && ch <= 'z') && !(ch >= 'A' && ch <= 'Z')) {
                    if (!sb.toString().equals(""))
                        sb.append(" ");
                } else
                    sb.append(ch);
            }
            String[] strs = sb.toString().split(" ");
            for (int i = strs.length - 1; i >= 0; i--) {
                if (i != 0)
                    System.out.print(strs[i] + " ");
                else
                    System.out.println(strs[i]);
            }
        }
    }
}


