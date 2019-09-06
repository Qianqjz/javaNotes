package com.algo.stack;

import java.io.IOException;

/**
 * 判断分隔符匹配。
 */
public class BrakerChecker {
    private String input;
    public BrakerChecker(String in){
        input=in;
    }
    public void check(){

        StackChar stackWord=new StackChar(input.length());

        for (int i=1;i<input.length();i++){
            char ch=input.charAt(i);

            switch (ch){
                case '{':
                case '[':
                case '(':
                    stackWord.push(ch);
                    break;
                case '}':
                case ']':
                case ')':
                    if(!stackWord.isEmpty()){
                        char chx=stackWord.pop();
                        if(ch=='}'&&ch=='{'||ch==']'&&ch=='['||ch==')'&&ch=='('){
                            System.out.println("error:"+i);
                        }
                    }else {
                        System.out.println("error:char"+i);
                        break;
                    }
                default:
                       break;
            }
        }
        if(!stackWord.isEmpty()){
            System.out.println("Error:miss right");
        }
    }

    public static void main(String[] args) throws IOException {
        String input;
        while(true){
            System.out.print("Enter a String 表达式：");
            System.out.flush();
            input= Untils.getString();
            if("".equals(input)){
                return;
            }
            BrakerChecker brakerChecker=new BrakerChecker(input);
            brakerChecker.check();

        }
    }

}
