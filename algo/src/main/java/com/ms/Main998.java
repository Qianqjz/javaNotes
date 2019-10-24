package com.ms;


import java.util.Stack;

/**
 * 栈的用法，解决四则混合运算
 * pop 是返回栈顶元素，同时删除该元素
 * peek 是是返回栈顶元素，不删除。，
 *
 */
public class Main998 {
    public static void main(String[] args) {
        String str="3+2*6-2";
        Stack<Integer> numstack=new Stack<Integer>(); 
        Stack<Character> operstack=new Stack<Character>(); 
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            //如果是数字直接入数字栈
            if(ch>='0' && ch<='9'){
                numstack.push(ch-'0');
            }
            //对符号进行判断
            if(ch=='+'||ch=='-'||ch=='*'||ch=='/'){
                if (operstack.isEmpty()){
                    operstack.push(ch);
                }else {
                    boolean priority=isPriority(ch,operstack.peek());
                    
                    if(priority){
                        int num1=numstack.pop();
                        int num2=numstack.pop();
                        char oper =operstack.pop();
                        int res=Cal(num2,oper,num1);
                        numstack.push(res);
                        operstack.push(ch);
                    }else {
                        operstack.push(ch);
                    }
                }
            }
            while (!operstack.isEmpty()){
                int num1=numstack.pop();
                int num2=numstack.pop();
                char oper =operstack.pop();
                int res=Cal(num2,oper,num1);
                numstack.push(res);
            }
            System.out.println(numstack.pop());
            
        }
        
        
    }

    public  static  int Cal(int num1,char oper,int num2){
        if(oper=='+'){
            return num1+num2;
        }else if(oper=='-'){
            return num2-num1;
        }else if(oper=='*'){
            return num1*num2;
        }else{
            return num2/num1;
        }
    }

    public static  boolean isPriority(char oper1,char oper2) {
        if ((oper1 == '/' || oper1 == '*') && (oper2 == '+' || oper2 == '-')) {
            return true;
        } else {
            return false;
        }
    }
}
