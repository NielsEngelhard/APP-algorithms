package com.company.lists;

import java.util.LinkedList;

public class MyOwnList<T> {
    private ListNode<T> headNode;

    public MyOwnList() {
        headNode = new ListNode<T>(null, null);
    }

    public boolean isEmpty() {
        return headNode.next == null;
    }

    public Iterator<T> find(T object) {
        ListNode<T> itr = headNode.next;
        while(itr != null && !itr.object.equals(object)) {
            itr = itr.next;
        }
        return new Iterator<T>(itr);
    }

    public void remove(T object) {
        Iterator<T> itr = findPrevious(object);
        if(itr.current.next != null) {
            itr.current.next = itr.current.next.next;
        }
    }

    public void add(T object, Iterator<T> itr) {
        if(itr != null && itr.current != null) {
            itr.current.next = new ListNode<T>(object, itr.current.next);
        }
    }

    public Iterator<T> findPrevious(T object) {
        ListNode<T> itr = headNode;
        while(itr.next != null && !itr.next.object.equals(object)) {
            itr = itr.next;
        }
        return new Iterator<T>(itr);
    }

    public void makeEmpty() {
        headNode.next = null;
    }

    // returns an iterator that represents the headNode
    public Iterator<T> zeroth() {
        return new Iterator<T>(headNode);
    }

    // represents the first node in the list (not the headNode)
    public Iterator<T> first() {
        return new Iterator<T>(headNode.next);
    }

    public static <T> void printList(MyOwnList<T> list) {
        if(list.isEmpty()) {
            System.out.println("The list is empty");
        } else {
            Iterator<T> itr = list.first(); // starting at the beginning of the list (with iterating)
            while(itr.isValid()) {
                System.out.println("value: " + itr.retrieve());
                itr.advance();
            }
        }
        System.out.println();
    }
}

class ListNode<T> {

    public ListNode(T object, ListNode<T> next) {
        this.object = object;
        this.next = next;
    }
    T object;
    ListNode<T> next;
}

class Iterator<T> {

    ListNode<T> current;

    Iterator(ListNode<T> theNode) {
        current = theNode;
    }

    public boolean isValid() {
        return current != null;
    }

    public T retrieve() {
        return isValid() ? current.object : null;
    }

    public void advance() {
        current = current.next;
    }
}
