package com.company.listsAndQueues.smalls;

import java.lang.reflect.Array;

public class MyOwnQue<T> {
    private int back;
    private int front;
    private int size;
    private T[] theArray;

    private static final int DEFAULT_CAPACITY = 10;

    public MyOwnQue(Class<T> c) {
        theArray = (T[]) new Object[DEFAULT_CAPACITY];
        makeEmpty();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void makeEmpty() {
        size = 0;
        front = 0;
        back = -1;
    }

    public T dequeue() {
        if( isEmpty( ) ) {
            System.out.println("Queue is empty");
            return null;
        }
        size--;
        T returnValue = theArray[ front ];
        front = increment(front);
        return returnValue;
    }

    public T getFront() {
        if(isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return theArray[front];
    }

    public void enqueue(T x) {
        if(size == theArray.length) {
            doubleQueue();
        }
        back = increment(back);
        theArray[back] = x;
        size++;

    }

    private void doubleQueue() {
        T[] newArray;
        newArray = (T[]) new Object[theArray.length * 2];

        for( int i = 0; i < size; i++, front = increment( front ) ) {
            newArray[i] = theArray[front];
        }
        theArray = newArray;
        front = 0;
        back = size - 1;
    }

    // internal method to increment with "wraparound"
    private int increment(int x) {
        if(++x == theArray.length) {
            x = 0;
        }
        return x;
    }
}
