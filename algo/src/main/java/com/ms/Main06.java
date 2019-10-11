package com.ms;

import java.util.Scanner;

/**
 *
 */

public class Main06 {
    private static String findPrimes(long lon){
        StringBuilder builder=new StringBuilder(128);
        long i=2;
        while(i<=lon){
            while(lon%i==0){
                builder.append(i).append(' ');
                lon/=i;
            }
            i++;
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNext()){
            long lon=scanner.nextLong();
            String primes = findPrimes(lon);
            System.out.println(primes);
        }
        scanner.close();
    }
}
