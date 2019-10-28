package com.ms;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main191 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Map<String,Integer> map=new LinkedHashMap<String, Integer>();
        while (scan.hasNext()) {
            String str = scan.nextLine();
            String[] arr=str.split(" ");
            String error=arr[0];
            String lineNo=arr[1];
            System.out.println(error);

            String fileName =error.substring(error.lastIndexOf("\\")+1);
            if (fileName.length()>16){
                fileName=fileName.substring(fileName.length()-16);
            }

            String error_name=fileName+ " "+lineNo;

            if(map.containsKey(error_name)){
                map.put(error_name,map.get(error_name)+1);
            }else {
                map.put(error_name,1);
            }

            int c=0;
            for (String k:map.keySet()){
                c++;
                if (c>map.size()-8){
                    System.out.println(c+" "+map.get(c));
                }
            }
        }
    }
}



