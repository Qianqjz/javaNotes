package com.ms;

import java.util.*;

public class Main53 {

    /*
     * @iNOC产品部-杨辉三角的变形
     *      1
     *   1  1  1
         1  2  3  2  1
      1  3  6  7  6  3  1
   1  4  10 16 19  16 10  4  1
   以上三角形的数阵，第一行只有一个数1，以下每行的每个数，是恰好是它上面的数，左上角数到右上角的数，3个数之和
   （如果不存在某个数，认为该数就是0）。
   求第n行第一个偶数出现的位置。如果没有偶数，则输出-1。例如输入3,则输出2，输入4则输出3。
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int x=scanner.nextInt();
            int result=findNumber(x);
            System.out.println(result);
        }

    }

    public static int findNumber(int x){
        if(x<3){
            return -1;
        }else if(x%2==1){
            return 2;
        }
        else
            return x/2%2+3;

    }
}
