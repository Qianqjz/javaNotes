package com.ms;

public class Main999 {
    public static void main(String[] args) {
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<100;i++){
            if(isPrimes(i)){
                builder.append(i).append(" ");
            }
        }
        System.out.println(builder);
    }

    private static boolean isPrimes(int n) {
        if(n<=3){
            return n>1;
        }
        for(int i=2;i<n;i++){
            if(n%i==0){
                return  false;
            }
        }
        return true;
    }
}
