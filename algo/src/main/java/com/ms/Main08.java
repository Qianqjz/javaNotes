package com.ms;

import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Main08 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            int pares=Integer.parseInt(scan.nextLine().trim());
            SortedMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
            for(int i=0;i<pares;i++){
                String[] nums=scan.nextLine().trim().split(" ");
                int key = Integer.parseInt(nums[0]);
                int value = Integer.parseInt(nums[1]);
                if(map.containsKey(key)){
                    map.put(key,map.get(key)+value);
                }else{
                    map.put(key,value);
                }
            };
            StringBuilder builder=new StringBuilder(256);
            for(SortedMap.Entry<Integer,Integer> e:map.entrySet()){
               builder.append(e.getKey()).append(" ").append(map.get(e.getKey())).append("\n");
            }
            System.out.println(builder);

        }
    }
}

