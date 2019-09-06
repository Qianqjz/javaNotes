package com.algo.recurrence;

/**
 * 汉诺塔，经典的递归，
 */
public class DiGuiDemo {

    public static void towerOfHanoi(int n,char frompeg,char topeg,char auxpeg){
        //如果只有一个盘子，直接返回
        if (n == 1) {
            System.out.println("Move disk 1 from peg: "+frompeg + " to peg : "+topeg);
            return;
        }
        //利用C柱作为辅助，将A柱上的n-1个盘子放在B柱；
        towerOfHanoi(n-1,frompeg,auxpeg,topeg);
        //将余下的盘子移动至C柱
        System.out.println("Move disk 1 from peg: "+frompeg + " to peg : "+topeg);
        //利用A柱作为辅助，将C柱的n-1个盘子移动至B柱；
        towerOfHanoi(n-1,auxpeg,topeg,frompeg);
    }

    /**
     * 执行结果：
     * Move disk 1 from peg: A to peg : B
     * Move disk 1 from peg: A to peg : C
     * Move disk 1 from peg: B to peg : C
     * Move disk 1 from peg: A to peg : B
     * Move disk 1 from peg: C to peg : A
     * Move disk 1 from peg: C to peg : B
     * Move disk 1 from peg: A to peg : B
     * @param args
     */
    public static void main(String[] args) {
        towerOfHanoi(3,'A','B','C');
    }

}

