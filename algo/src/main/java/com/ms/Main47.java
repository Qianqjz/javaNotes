package com.ms;

import java.util.Scanner;

public class Main47 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            int n = scan.nextInt();
            System.out.println(getResult());

        }
    }

    private static String getResult() {
        StringBuilder builder=new StringBuilder();
        for(int x=0;x<=20;x++){
            for (int y=0;y<=33;y++){
                //小鸡的数量
                int z=100-x-y;
                if(z%3==0&&(100==5*x+3*y+z/3)){
                    builder.append(x+" "+y+" "+z).append("\n");
                }
            }
        }
        return builder.toString();
    }
}
