package com.algo.binaryTree;

import java.util.Stack;

/**
 * 学习二叉树
 */
public class Tree {
    private Node root;

    public Tree(){

    }
    public Tree(Node root) {
        this.root = root;
    }

    /**
     * 查找
     * @param key
     * @return
     */
    public Node find(int key){
        Node current=root;
        while(current.iData!=key){
            if(key<current.iData){
                current=current.leftChild;
            }else {
                current=current.rightChild;
            }
            if (current==null){
                return  null;
            }
        }
        return current;
    }

    /**
     * 插入一个节点
     * @param id
     * @param dd
     */
    public void insert(int id,double dd){
        Node newNode=new Node();
        newNode.iData=id;
        newNode.dData=dd;
        if (root==null){
            root = newNode;
        }else{
            Node current=root;
            Node parent;
            while(true){
                parent=current;
                if (id<current.iData){
                    current=current.leftChild;
                    if (current==null){
                        parent.leftChild=newNode;
                        return;
                    }
                }else {
                    current=current.rightChild;
                    if (current==null){
                        parent.rightChild=newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 删除节点
     * @param key
     * @return
     */
    public boolean delete(int key){
        Node current=root;
        Node parent=root;
        boolean isLeftChild=true;

        while (current.iData!=key){
            parent=current;
            if (key<current.iData){
                isLeftChild=true;
                current=current.leftChild;
            }else {
                isLeftChild =false;
                current=current.rightChild;
            }
            if (current==null){
                return false;
            }

            if (current.leftChild==null&&current.rightChild==null){
                if (current==root){
                    root=null;
                }else if(isLeftChild) {
                    parent.leftChild=null;
                }else {
                    parent.rightChild=null;
                }
            }else if(current.rightChild==null){
                if(current==root){
                    root=current.leftChild;
                }else if (isLeftChild){
                    parent.leftChild=current.leftChild;
                }else {
                    parent.rightChild=current.rightChild;
                }
            }else if (current.leftChild == null){
                if(current==root){
                    root = current.rightChild;
                }else if (isLeftChild){
                    parent.leftChild =current.rightChild;
                }else {
                    parent.rightChild=current.rightChild;
                }
            }else {
                Node successor=getSuccessor(current);
                if(current==root){
                    root = successor;
                }else if (isLeftChild){
                    parent.leftChild=successor;
                }else {
                    parent.rightChild=successor;
                }
                successor.leftChild=current.leftChild;
            }
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent=delNode;
        Node successor =delNode;
        Node current=delNode.rightChild;
        while (current!=null){
            successorParent=successor;
            successor=current;
            current=current.leftChild;
        }
        if (successor!=delNode.rightChild){
            successorParent.leftChild=successor.rightChild;
            successor.rightChild=delNode.rightChild;
        }

        return successor;
    }

    /**
     * 三种遍历方法 前序，中序，后序
     * @param traverseType
     */
    public void traverse(int traverseType){
        switch (traverseType){
            case 1:
                System.out.println("\nPreorder travers");
                preOrder(root);
                break;
            case 2:
                System.out.println("\ninOrder travers");
                inOrder(root);
                break;
            case 3:
                System.out.println("\npostOrder travers");
                postOrder(root);
                break;
        }
        System.out.println();
    }

    private void preOrder(Node localRoot) {
        if (localRoot != null){
            System.out.print(localRoot.iData+" ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {
        if (localRoot != null){
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.iData+" ");
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {
        if (localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.iData+" ");
        }
    }

    public  void displayTree(){
        Stack globalStack=new Stack();
        globalStack.push(root);
        int nBlank =32;
        boolean isRowEmpty=false;
        System.out.println(".................................");
        while (isRowEmpty==false){
            Stack localStack=new Stack();
            isRowEmpty= true;

            for (int j=0;j<nBlank;j++){
                System.out.print(' ');
            }
            while (globalStack.isEmpty()==false){
                Node temp=(Node)globalStack.pop();
                if (temp!=null){
                    System.out.println(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild!=null||temp.rightChild!=null){
                        isRowEmpty=false;
                    }
                }else {
                    System.out.print("..");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j=0;j<nBlank*2-2;j++){
                    System.out.print(' ');
                }
            }
            System.out.println();
            nBlank/=2;
            while (localStack.isEmpty()==false){
                globalStack.push(localStack.pop());
            }
        }
        System.out.println(".........................");
    }

}
