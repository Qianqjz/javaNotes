package com.ms;

import java.util.Scanner;

public class Main16 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            String input=scan.nextLine();

            System.out.println(move(input));

        }
    }

    private static String move(String input) {
        String[] split = input.split(";");
        int[] result=new int[2];
        for(String st:split){
            move(st,result);
        }
        return result[0]+";"+result[1];
    }

    private static void move(String input, int[] result) {
        if(input.matches("(A|S|D|W)[0-9]{1,2}")){
            char dir=input.charAt(0);
            int step=Integer.parseInt(input.substring(1));
            switch (dir){
                case 'A':
                    result[0]-=step;
                    break;
                case 'D':
                    result[0]+=step;
                    break;
                case 'S':
                    result[1]-=step;
                    break;
                case 'W':
                    result[1]+=step;
                    break;
            }
        }
    }
}

