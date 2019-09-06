//package com.suanfa.binaryTree;
//
//public class BinaryTree {
//
//	private BinaryTreeNode root; //创造一个根节点
//
//	public BinaryTree() {
//		super();
//	}
//
//	public BinaryTree( BinaryTreeNode root) {
//		super();
//		this.root = root;
//	}
//
//	public BinaryTreeNode getRoot() {
//		return root;
//	}
//
//	public void setRoot( BinaryTreeNode root) {
//		this.root = root;
//	}
//
//	/**
//	 * 删除所有的子节点
//	 * @param node
//	 */
//	public void clear( BinaryTreeNode node){
//		if(node !=null){
//			clear(node.getLeftChild());
//			clear(node.getRightChild());
//			node = null; //删除子节点
//		}
//	}
//	/**
//	 * 删除所有节点
//	 */
//	public void clear(){
//		clear(root);
//	}
//
//	/**
//	 * 判断是否为空
//	 * @return
//	 */
//	public boolean isEmpty(){
//		return root==null;
//	}
//
//	/**
//	 * 获取所有树的高度
//	 * @param node
//	 * @return
//	 */
//	public int heigh( BinaryTreeNode node){
//		if(node==null){
//			return 0;
//		}else{
//			int rightHeigh=heigh(node.getRightChild());	//获取右子树的高度
//			int leftHeigh=heigh(node.getLeftChild()); //获取左子树的高度
//			return rightHeigh>leftHeigh?(rightHeigh+1):(leftHeigh+1);//比较左子树与右子树高度 ，注意加一的细节
//		}
//	}
//	/**
//	 * 获取整个二叉树的高度
//	 * @return
//	 */
//	public int heigh(){
//		return heigh(root);
//	}
//
//	/**
//	 * 获取所有节点的个数
//	 * @param node
//	 * @return
//	 */
//
//	public int size( BinaryTreeNode node){
//		if(node == null){
//			return 0;
//		}else{
//			return 1+size(node.getLeftChild())+size(node.getRightChild());
//		}
//	}
//	/**
//	 * 获取整个树的节点数
//	 * @return
//	 */
//	public int size(){
//		return size(root);
//	}
//
//	/**
//	 * 获取父节点
//	 * @param subTree
//	 * @param node
//	 * @return
//	 */
//	public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node){
//		//如果父节点为空，直接返回
//		if(subTree == null){
//			return null;
//		}
//		//如果父节点的左子树或者右子树为node节点，说明node节点的父节点为subTree
//		if(subTree.getLeftChild()==node ||subTree.getRightChild()==node){
//			return subTree;
//		}
//		//获取参数中父节点的右子节点是否为空，不为空，则为node节点的父节点，否则，subtree的左子节点为node节点的父节点
//		if(getParent(subTree.getRightChild(),node)!=null){
//			return getParent(subTree.getRightChild(),node);
//		}else{
//			return getParent(subTree.getLeftChild(),node);
//		}
//
//	}
//	public BinaryTreeNode getParent(BinaryTreeNode node){
//		return (root==null||root==node)?null:getParent(root,node);
//	}
//
//	/**
//	 * 获取右子节点
//	 * @param node
//	 * @return
//	 */
//	public com.binaryTree.BinaryTreeNode getRightNode(com.binaryTree.BinaryTreeNode node){
//		return node.getRightChild();
//	}
//	/**
//	 * 获取左子节点
//	 * @param node
//	 * @return
//	 */
//	public com.binaryTree.BinaryTreeNode getLeftNode(com.binaryTree.BinaryTreeNode node){
//		return node.getLeftChild();
//	}
//	/**
//	 * 插入右子节点
//	 * @param parent
//	 * @param node
//	 */
//	public void insertRightNode(com.binaryTree.BinaryTreeNode parent, com.binaryTree.BinaryTreeNode node){
//		parent.setRightChild(node);
//	}
//	/**
//	 * 插入左子节点
//	 * @param parent
//	 * @param node
//	 */
//	public void insertLeftNode(com.binaryTree.BinaryTreeNode parent, com.binaryTree.BinaryTreeNode node){
//		parent.setLeftChild(node);
//	}
//	/**
//	 * 前序遍历二叉树
//	 * @param node
//	 */
//	public void preOrder( com.binaryTree.BinaryTreeNode node){
//		if(node!=null){
//			System.out.println("前序遍历----> "+node.getData());
//			preOrder(node.getLeftChild());
//			preOrder(node.getRightChild());
//		}
//	}
//	public void inOrder( com.binaryTree.BinaryTreeNode node){
//		if(node!=null){
//			preOrder(node.getLeftChild());
//			System.out.println("中序遍历----> "+node.getData());
//			preOrder(node.getRightChild());
//		}
//	}
//	public void postOrder( com.binaryTree.BinaryTreeNode node){
//		if(node!=null){
//			postOrder(node.getLeftChild());
//			postOrder(node.getRightChild());
//			System.out.println("后续遍历 ---> "+node.getData());
//		}
//	}
//
//
//}
