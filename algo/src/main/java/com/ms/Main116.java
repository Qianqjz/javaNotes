package com.ms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main116 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
           String str=scan.nextLine();
           String[] strs=str.split(" ");
            List<Integer> list=new ArrayList<Integer>();
           for(int i=0;i<strs.length;i++){
               list.add(Integer.parseInt(strs[i]));
           }
           boolean flag=fun(list);
            System.out.println(flag);
        }
    }

    private static boolean fun(List<Integer> list) {
        for (int i=0;i<list.size();i++){
            int temp=list.get(i);
            list.remove(i);
            if(getResult(list,temp)){
                return  true;
            }
            list.add(i,temp);
        }
        return false;
    }

    private static boolean getResult(List<Integer> list, int temp) {
        if(list.size()>0){
            for (int i=0;i<list.size();i++){
                int n=list.get(i);
                list.remove(i);
                if(getResult(list,temp*n)||getResult(list,temp-n)||getResult(list,temp+n)){
                   return true;
                }else if(temp%n==0){
                    if(getResult(list,temp/n)){
                        return  true;
                    }
                }
                list.add(i,n);
            }
            return false;
        }else {
            if(temp==24){
                return true;
            }else {
                return false;
            }
        }
    }
}
