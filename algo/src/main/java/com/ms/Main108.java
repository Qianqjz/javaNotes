package com.ms;

import java.util.*;

public class Main108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            double n = sc.nextDouble();
            System.out.printf("%.5f", getDouble(n));
            System.out.println();
            System.out.printf("%.5f", getCubeRoot(n));
        }
    }
    private static double getDouble(double n){
        double e = 0.000001;
        double a = n;
        double a1 = (2 * a + n / a / a) / 3;
        while (Math.abs(a1 * a1 * a1 - n) > e) {
            a1 = (2 * a1 + n / a1 / a1) / 3;
        }
        return a1;
    }

    public static double getCubeRoot(double input) {
        double min = 0;
        double max = input;
        double mid = 0;
        while ((max - min) > 0.000001) {
            mid = (max + min) / 2;
            if (mid * mid * mid > input) {
                max = mid;
                continue;
            }
            if (mid * mid * mid < input) {
                min = mid;
                continue;
            }
            return mid;
        }
        return max;
    }

}








