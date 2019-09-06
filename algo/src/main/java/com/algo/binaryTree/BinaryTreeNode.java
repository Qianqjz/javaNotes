package com.algo.binaryTree;

/**
 * 定义一棵二叉树
 * 
 * @author Administrator
 *
 */
public class BinaryTreeNode {

	private int data; //层数
	private BinaryTreeNode leftChild;//左子树
	private BinaryTreeNode rightChild;//右子树
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}
	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}
	public BinaryTreeNode getRightChild() {
		return rightChild;
	}
	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}
	
	
	
}
