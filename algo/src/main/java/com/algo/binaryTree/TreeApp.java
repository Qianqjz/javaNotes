package com.algo.binaryTree;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TreeApp {
    public static void main(String[] args) throws Exception {
        int value;
        Tree theTree=new Tree();

        theTree.insert(50,1.5);
        theTree.insert(25,1.2);
        theTree.insert(75,1.7);
        theTree.insert(12,1.5);
        theTree.insert(37,1.2);
        theTree.insert(43,1.7);
        theTree.insert(30,1.5);
        theTree.insert(33,1.2);
        theTree.insert(87,1.7);
        theTree.insert(93,1.5);
        theTree.insert(97,1.5);

        while (true){
            System.out.print("enter first letter of show: ");
            System.out.print(" insert , find , delete, or traverse : ");
            int choice =getChar();
            switch (choice){
                case 's':
                    theTree.displayTree();
                    break;
                case 'i':
                    System.out.print("enter value to insert : ");
                    value=getInt();
                    theTree.insert(value,value+0.9);
                    break;
                case 'f':
                    System.out.print("enter value to find :");
                    value=getInt();
                    Node found=theTree.find(value);
                    if (found!=null){
                        System.out.print("found :");
                        found.disPlayNode();
                        System.out.print("\n");
                    }else {
                        System.out.print("cound not find ");
                        System.out.print(value+'\n');
                        break;
                    }
                case 'd':
                    System.out.print("enter value  to delete: ");
                    value =getInt();
                    boolean didDelete =theTree.delete(value);
                    if (didDelete){
                        System.out.print("deleted " +value+'\n');
                    }else {
                        System.out.print("could not delete ");
                        System.out.print(value +'\n');
                    }
                    break;
                case 't':
                    System.out.print("enter type 1,2,3: ");
                    value=getInt();
                    theTree.traverse(value);
                    break;
                default:
                    System.out.print(" invalid entrt \n");
            }
        }
    }

    public static String getString() throws Exception{
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        return br.readLine();
    }
    public static char getChar() throws Exception{
        return getString().charAt(0);
    }
    public  static int getInt() throws Exception{
        return Integer.parseInt(getString());
    }
}
