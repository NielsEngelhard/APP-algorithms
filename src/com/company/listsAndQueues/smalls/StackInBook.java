package com.company.listsAndQueues.smalls;

import java.nio.BufferUnderflowException;

public class StackInBook<T> {
    private T[] theArray;
    private int topOfStack;
    private static final int DEFAULT_CAPACITY = 2;

    public StackInBook() {
        theArray = (T[]) new Object[DEFAULT_CAPACITY];
        topOfStack = -1;
    }

    // check if logically empty
    public boolean isEmpty() {
        return topOfStack == -1;
    }

    // make logically empty
    public void makeEmpty() {
        topOfStack = -1;
    }

    // insert a new item into the stack
    public void push(T x) {
        if(topOfStack + 1 == theArray.length) {
            doubleArray();
        }
        theArray[++topOfStack] = x;
    }

    public T top() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return theArray[topOfStack];
    }

    public void pop() {
        if(isEmpty()) {
            System.out.println("Cant pop, stack is empty");
        }
        topOfStack--;
    }

    public T topAndPop() {
        if(isEmpty()) {
            System.out.println("Cant top and pop, stack is empty");
        }
        return theArray[topOfStack--];
    }

    public void doubleArray() {
        T[] tmpArray = theArray;
        theArray = (T[]) new Object[tmpArray.length * 2];
        System.arraycopy(tmpArray, 0, theArray, 0, tmpArray.length);
    }

    public static void main(String[] args) {
        StackInBook<String> stack = new StackInBook<String>();
        stack.push("first added");
        stack.push("second added");
        stack.push("third added");
        System.out.println(stack.topAndPop());
        System.out.println(stack.topAndPop());
        System.out.println(stack.topAndPop());
        System.out.println(stack.topAndPop());
    }

}
