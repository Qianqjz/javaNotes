package com.ms;

import java.util.Scanner;

public class Main29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int input = scanner.nextInt();
            System.out.println(count(input));
        }

    }

    private static int count(int input) {
        if(input<=0){
            return 0;
        }else if(input<=2){
            return 1;
        }else {
            int prev1=1;
            int prev2=1;
            int result=0;
            for(int i = 3;i<=input;i++){
                result=prev1+prev2;
                //将下一个月的兔子数量给前一个月
                prev1=prev2;
                prev2=result;
            }
            return result;
        }
    }
}
