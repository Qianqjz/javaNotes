package com.ms;

public class Main127 {
    //    private static  boolean isPrimes(int n){
//        if(n<3){
//            return n>1;
//        }
//        int sqr=(int)Math.sqrt(n);
//        System.out.println("======:"+(int)Math.sqrt(20));
//        System.out.println("----->:"+Math.sqrt(20));
//        for(int i=2;i<=sqr;i++){
//            if(n%i==0){
//                return false;
//            }
//        }
//        return  true;
//    }
    private static boolean isPrimes(int n) {
        if (n < 3) {
            return n > 1;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            if (isPrimes(i)) {
                System.out.println(i);
            }
        }
    }
}
