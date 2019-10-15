package com.ms;


import java.util.Scanner;

class Main61 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            arr[0] = 2;
            long lon = 0;
            for (int i = 1; i < n; i++) {
                arr[i] = arr[i - 1] + 3;
            }
            for (int i = 0; i < n; i++) {
                lon += arr[i];
            }
            System.out.println(lon);
        }
    }
}





