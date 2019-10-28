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
        // 传入要查找节点的索引，首先从根节点开始 ，当前节点索引为根节点索引
        Node current=root;
        //如果当前节点的索引不等于要查找节点的索引值
        while(current.iData!=key){
            //如果查找的索引小于当前节点索引
            if(key<current.iData){
                //取当前节点的左子节点
                current=current.leftChild;
            }else {
                //否则取当前节点的右子节点
                current=current.rightChild;
            }
            //如果当前节点为空，则说明没有找到，则返回空 。
            if (current==null){
                return  null;
            }
        }
        //直到找到查到节点
        return current;
    }

    /**
     * 插入一个节点
     * @param id
     * @param dd
     */
    public void insert(int id,double dd){
        //新建一个节点
        Node newNode=new Node();
        //赋值要插入的索引值
        newNode.iData=id;
        //赋值要插入的值
        newNode.dData=dd;
        //如果根节点为空，直接将新建的节点赋值为根节点
        if (root==null){
            root = newNode;
        }else{
            //否则，当前节点为根节点
            Node current=root;
            //设置一个父节点
            Node parent;
            //死循环
            while(true){
                //将当前节点赋值为父节点
                parent=current;
                //如果要插入的节点的索引小于当前节点的索引
                if (id<current.iData){
                    //则当前节点变更为之前节点的左子节点
                    current=current.leftChild;
                    //如果变更后的当前节点为空，
                    if (current==null){
                        //在将新建的节点赋值为当前节点父节点的左子节点
                        parent.leftChild=newNode;
                        //返回
                        return;
                    }
                }else {
                    //如果要插入的节点的索引大于当前节点的索引
                    //则当前节点变更为之前节点的右子节点
                    current=current.rightChild;
                    //如果变更后的当前节点为空，
                    if (current==null){
                        //在将新建的节点赋值为当前节点父节点的右子节点
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
        //创建当前节点为根节点
        Node current=root;
        //创建父节点
        Node parent=root;
        //开关初始值为打开 是否为左子节点
        boolean isLeftChild=true;
        //如果当前节点的索引不等于要删除的节点索引
        while (current.iData!=key){

            /**
             * 1. 先要找到删除的节点
             *  使用的是查找节点得方法
             */

            //将当前节点赋值给父节点
            parent=current;
            //如果要删除的索引值小于当前节点的索引
            if (key<current.iData){
                //开关打开
                isLeftChild=true;
                //将当前节点赋值为左子节点
                current=current.leftChild;
            }else {
                //否则开关关闭，说明不是左子节点
                isLeftChild =false;
                //将当前节点赋值为当前节点的有子节点
                current=current.rightChild;
            }
            //如果当前节点为空，直接返回，说明删除失败，没有找到要删除的节点
            if (current==null){
                return false;
            }

            /**
             *  2. 删除第一步找到的节点
             *      2.1 当前节点的左右子节点都为空。
             *      2.2 当前节点的右子节点为空
             *      2.3 当前节点的左子节点为空
             *      2.4 其他情况
             */

             //如果当前节点的左，右子节点都等于空
            if (current.leftChild==null&&current.rightChild==null){
                //如果当前节点等于根节点，直接将根节点赋值为空，相当于删除
                if (current==root){
                    root=null;
                    //如果开关为开启，在说明当前节点的左子节点存在索引，直接将当前节点左子节点赋值为空
                }else if(isLeftChild) {
                    parent.leftChild=null;
                }else {
                    //如果开关为关闭，在说明当前节点的右子节点存在索引，直接将当前节点右子节点赋值为空
                    parent.rightChild=null;
                }
                //如果当前节点的右子节点为空
            }else if(current.rightChild==null){
                if(current==root){
                    root=current.leftChild;
                }else if (isLeftChild){
                    //将当前节点的左子节点赋值为父节点的左子节点
                    parent.leftChild=current.leftChild;
                }else {
                    //将当前节点的左子节点赋值为父节点的左子节点
                    parent.rightChild=current.rightChild;
                }
                //如果当前节点的左子节点为空
            }else if (current.leftChild == null){
                if(current==root){
                    root = current.rightChild;
                }else if (isLeftChild){
                    //将当前节点的右子节点赋值为父节点的左子节点
                    parent.leftChild =current.rightChild;
                }else {
                    //将当前节点的右子节点赋值为父节点的右子节点
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
    //
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
                    System.out.print(temp.iData);
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
