package com.ms;

import java.util.*;

public class Main123 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            //输入数量
           int n=sc.nextInt();
           String[] input=new String[n];
            for(int i=0;i<input.length;i++){
                input[i]=sc.next();
            }
            String rs="";
            String goal=sc.next();
            int m=sc.nextInt();
            int count =0;
            ArrayList<String> arrayList=new ArrayList<String>();
            for(int i=0;i<input.length;i++){
                if(input[i].length()==goal.length()&&!input[i].equals(goal)){
                    if(Equle(input[i],goal)){
                        count++;
                        arrayList.add(input[i]);
                    }

                }
            }
            Collections.sort(arrayList);
//            System.out.println(arrayList);
            System.out.println(count);
            if(arrayList.size()>=m){
                System.out.println(arrayList.get(m-1));
            }
        }
    }

    private static boolean Equle(String strA, String strB) {
        int[] A=new int[26];
        int[] B=new int[26];
        for(int i=0;i<strA.length();i++){
            A[strA.charAt(i)-'a']++;
            B[strB.charAt(i)-'a']++;
        }
        for(int i=0;i<A.length;i++){
            if(A[i]!=B[i]){
                return false;
            }
        }
        return true;
    }


}
