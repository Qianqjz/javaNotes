package com.ms;

import java.util.*;
public class Main121 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            SortedSet<Integer> set = new TreeSet<Integer>();
            for (int i = 0; i < m; i++) {
                set.add(scanner.nextInt());
            }

            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                set.add(scanner.nextInt());
            }
            for (Integer i : set) {
                System.out.print(i);
            }
        }

        scanner.close();
    }
}
