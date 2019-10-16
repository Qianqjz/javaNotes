package com.ms;

import java.util.*;

/**
 * hello world
 */

public class Main34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            System.out.println(getFirst(input));
        }
    }

    private static char getFirst(String input) {
        int MAX=Integer.MAX_VALUE;
        Map<Character,Integer> map=new HashMap<Character, Integer>();
        for(int i=0;i<input.length();i++){
            char c=input.charAt(i);
            if(map.containsKey(c)){
                map.put(c,MAX);
            }else {
                map.put(c,i);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i:map.values()){
            if(min>i){
                min=i;
            }
        }
        return min==Integer.MAX_VALUE?'.':input.charAt(min);
    }
}


