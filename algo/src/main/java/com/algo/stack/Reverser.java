package com.algo.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  变更单词顺序
 * @author carl
 *
 */
public class Reverser {

    private String input;
    private String output;
    public Reverser(String in) {
        input = in;
    }

    public String doRev() {
        StackChar stackx=new StackChar(input.length());
        for(int i=0;i<input.length();i++) {
            char ch=input.charAt(i);
            stackx.push(ch);
        }

        output ="";

        while(!stackx.isEmpty()) {
            output=output+stackx.pop();
        }
        return output;
    }


    public static void main(String[] args) throws IOException {

        String input,output;
        while(true) {
            System.out.println("enter a word: ");
            System.out.flush();
            input= Untils.getString();
            if("".equals(input)) {
                return;
            }
            Reverser rev=new Reverser(input);
            System.out.println(rev.doRev());
        }

    }

}
