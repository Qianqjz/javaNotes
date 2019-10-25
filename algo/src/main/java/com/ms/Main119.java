package com.ms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main119 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            int n=scan.nextInt();
            List<String> list=new ArrayList<>();
            while(--n>=0){
                list.add(scan.nextLine());
            }
            System.out.println(count(list));
        }
    }

    private static String count(List<String> list) {

        StringBuilder builder=new StringBuilder();
        for (String s:list){
            int result=0;
            int[] seq=new int[26];
            //遍历出来的每一个名字
            for(int i=0;i<s.length();i++){
                char c=s.charAt(i);
                if(c>='a'&&c<='z'){
                    seq[c-'a']++;
                }else {
                    seq[c-'A']++;

                }
            }
            //排序
            Arrays.sort(seq);
            for(int i=0;i<seq.length;i++){
                result+=seq[i]*(i+1);
            }
            builder.append(result).append("\n");

        }
        return builder.toString();
    }
}
