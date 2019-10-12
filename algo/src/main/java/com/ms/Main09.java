package com.ms;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main09 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        while(scan.hasNext()){
            long pases=scan.nextLong();
            String str=String.valueOf(pases);
            StringBuilder builder=new StringBuilder(128);
//            HashSet<Character> hashset=new LinkedHashSet<>();
            Set<Character> hashset=new LinkedHashSet<Character>();
            for(int i=0;i<str.length();i++){
                hashset.add(str.charAt(i));
            }
            for(Character c:hashset){
                builder.append(c);
            }
            if(builder.charAt(0)=='0'){
                builder.substring(1,builder.length());
            }
            System.out.println(builder);
        }
    }
}

