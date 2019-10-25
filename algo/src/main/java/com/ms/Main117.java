package com.ms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main117 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext()){
            String s1=scan.nextLine();
            String s2=scan.nextLine();
            System.out.println(encrypt(s1,s2));

        }
    }

    private static String encrypt(String mask, String s) {
        HashSet<Character> set=new LinkedHashSet<>();
        //这是在处理密码全部使用大写
        for (int i=0;i<mask.length();i++){
            char c=mask.charAt(i);
            if (c>='a'&&c<='z'){
                set.add((char)(c-'a'+'A'));
            }else if(c>='A'&&c<='Z'){
                set.add(c);
            }
        }
        for(int i=0;i<26;i++){
            set.add((char)('A'+i));
        }

        Character[] covert=set.toArray(new Character[set.size()]);
        System.out.println(Arrays.toString(covert));
        char[] result= s.toCharArray();
        for(int i=0;i<result.length;i++){
            char c=result[i];
            if(c>='a'&&c<='z'){
                result[i]=(char)(covert[c-'a']-'A'+'a');
            }else  if(c>='A'&&c<='Z'){
                result[i]=covert[c-'A'];
            }

        }

        return new String(result);
    }

}
