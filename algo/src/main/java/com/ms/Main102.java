package com.ms;

import java.util.Arrays;
import java.util.Scanner;

class Main102 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
            }
            int tag = scan.nextInt();
            System.out.println(sortArr(sort(arr), tag));
        }
    }

    private static String sortArr(int[] arr, int tag) {
        StringBuilder builder = new StringBuilder();

        if (tag == 1) {
            for (int i = arr.length - 1; i >= 0; i++) {
                builder.append(arr[i]).append(" ");
            }
        } else {
            for (int i = 0; i <arr.length; i++) {
                builder.append(arr[i]).append(" ");
            }
        }
        return builder.substring(0, builder.length() - 1);
    }

    private static int[] sort(int[] arr) {
        Arrays.sort(arr);
        return arr;
    }
}





