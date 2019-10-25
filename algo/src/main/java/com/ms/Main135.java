package com.ms;

import java.util.Scanner;

public class Main135 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            int n=scan.nextInt();
            System.out.println(getResult(n));
        }
    }

    private static String getResult(int n) {
        for(int i=n/2;i>=2;i--){
            if(isPrime(i)&&isPrime(n-i)){
//                if(isPrimes(i)&&isPrimes(n-i)){
                return i+"\n"+(n-i);
            }
        }
        return null;
    }

    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        int sqrt = (int) Math.sqrt(n);

        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
    private static  boolean isPrimes(int n){
        if(n<3){
            return n>1;
        }
        for(int i=2;i<n;i++){
            if(n%i!=0){
                return false;
            }
        }
        return  true;
    }
}
