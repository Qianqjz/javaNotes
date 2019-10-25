package com.ms;

import java.util.Scanner;

public class Main125 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String[] mask = sc.next().split("\\.");
        String[] ip1 = sc.next().split("\\.");
        String[] ip2 = sc.next().split("\\.");

        for (int i=0;i<4;i++){
            if((Integer.parseInt(mask[i])<0 && Integer.parseInt(mask[i])>255)||
                    (Integer.parseInt(ip1[i])<0 && Integer.parseInt(ip1[i])>255)||
            (Integer.parseInt(ip2[i])<0 && Integer.parseInt(ip2[i])>255)||(mask.length>4)||(ip1.length>4)||(ip2.length>4)){
                System.out.println(1);
            }else if((Integer.parseInt(mask[i]) & Integer.parseInt(mask[i]))==(Integer.parseInt(mask[i])& Integer.parseInt(ip2[i]))){
                System.out.println(0);
            }else{
                System.out.println(2);
            }
        }

    }
}
