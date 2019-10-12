package com.ms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main14 {
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int num=scan.nextInt();
            List<String> list=new ArrayList<String>(num);
            while((num--)>=0){
                list.add(scan.nextLine().trim());
            }
            Collections.sort(list);
            for (String s:list){
                System.out.println(s);
            }
        }
    }
}

