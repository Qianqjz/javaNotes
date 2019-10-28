package com.algo.binaryTree;

public class Node {
    //节点索引值
    public int iData;
    //节点数值
    public double dData;
    //左子节点
    public Node leftChild;
    //右子节点
    public Node rightChild;

    public void disPlayNode(){
        System.out.print("{");
        System.out.print(iData);
        System.out.print(",");
        System.out.print(dData);
        System.out.print("}");
    }
}
