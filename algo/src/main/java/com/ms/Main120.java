package com.ms;

import java.util.Scanner;


public class Main120 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            //链表的项数
            int num=scan.nextInt();
            //链表数组
            String[] values=scan.nextLine().split(" ");
            //倒数的k值
            int k=scan.nextInt();
            //创建出一个链表并返回头元素
            Node head=createList(values);
            if(k==0){
                System.out.println(0);
            }else {

                Node result=lastValueList(head,k);
                System.out.println(result.value);
            }
        }
    }

    private static Node lastValueList(Node head, int k) {
        //定义两个node
        Node fast=head;
        Node slow=head;
        //如果到k-1,下一个就是k了，
        for (int i=0;i<k-1;i++){
            fast=fast.next;
        }
        //先判断k的下一个不是空，
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }

    private static Node createList(String[] values) {
        if (values.length<=0) {
            return null;
        }
        Node head=new Node(Integer.valueOf(values[0]));
        Node temp=head;
        for(int i=1;i<values.length;i++){
           temp.next=new Node(Integer.valueOf(values[i]));
           temp=temp.next;
        }
        return head;
    }

    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
}
