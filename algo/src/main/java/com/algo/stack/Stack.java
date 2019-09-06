package com.algo.stack;

class StackX {

    private int maxSize;
    private long[] stackArray;
    private int top;

    public StackX(int s) {
        maxSize = s;
        stackArray = new long[maxSize];
        top = -1;
    }

    public void push(long j) {
        stackArray[++top] = j;
    }

    public Object pop() {
        return stackArray[top--];
    }

    public Object peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

}

public class Stack {
    public static void main(String[] args) {
        StackX stackx = new StackX(10);
        stackx.push(21);
        stackx.push(24);
        stackx.push(11);
        stackx.push(54);
        stackx.push(188);
        while (!stackx.isEmpty()) {
            System.out.println(stackx.pop());
        }

    }
}
