package com.ms;


import java.util.Scanner;

/**
 * hello world
 */

public class Main31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(Main.class.getClassLoader().getResourceAsStream("data.txt"));
        while (scanner.hasNext()) {
            double h = scanner.nextDouble();
            System.out.printf("%g\n", getJourney(h));
            System.out.printf("%g\n", getTenthHigh(h));
        }

        scanner.close();
    }

    private static double getTenthHigh(double h) {
        return h / 32;
    }

    private static double getJourney(double h) {

        double up = (Math.pow(0.5, 4) - 1) / (0.5 - 1);
        double down = (Math.pow(0.5, 5) - 1) / (0.5 - 1);

        return h * 0.5 * up + h * down;
    }

    public static double getJourney(double h,int count){
        double result=0;
        for(int i=1;i<=count;i++){
            result=result+(h*1.5)*Math.pow(0.5,i-1);
        }
        return result-h/32;
    }
}


