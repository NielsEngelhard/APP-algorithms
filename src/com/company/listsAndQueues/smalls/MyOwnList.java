package com.company.listsAndQueues.smalls;

public class MyOwnList<T> {
    ListNode<T> headNode;
    ListNode<T> firstPosition;

    public MyOwnList() {
        headNode = new ListNode<T>(null);
        firstPosition = headNode;
    }

    public void addFirst(T object) {
        ListNode<T> newNode = new ListNode<T>(object);
        newNode.next = firstPosition;
        firstPosition = newNode;
    }

    public void removeFirst() {
        ListNode<T> toDelete = firstPosition;
        if(!isEmpty()) {
            firstPosition = firstPosition.next;
        } else {
            System.out.println("list is empty");
        }
    }

    public void add(int index, T value) {
        ListNode<T> toAdd = new ListNode<>(value);
        ListNode<T> current = firstPosition;
        for(int i = 0; i < index - 1; i++) {
            if (current.next != null) {
                current = current.next;
            }
        }
        toAdd.next = current.next;
        current.next = toAdd;
    }

    public void remove(int index) {
        ListNode<T> current = firstPosition;

        current.next = current.next.next;
    }

    public T get(int index) {
        ListNode<T> current = firstPosition;
        for(int i = 0; i <= index - 1; i++) {
            if(current.next != null) {
                current = current.next;
            } else {
                System.out.println("position does not exist");
                return null;
            }
        }
        return current.object;
    }

    public boolean isEmpty() {
        return firstPosition == null;
    }

    public void printList() {
        ListNode<T> current = firstPosition;
        while(current.next != null) {
            System.out.println(current.object);

            current = current.next;
        }
    }

    public static void main(String[] args) {
        MyOwnList<String> list = new MyOwnList<>();
        for(int i = 0; i < 100; i++) {
            list.addFirst("OBJECT " + i);
        }
        //list.printList();

        //System.out.println("lol " + list.get(101));

        list.add(1, "OBJECT ON INDEX 1");
        list.printList();
        list.remove(1);
        list.printList();
    }
}

class ListNode<T> {

    public T object;
    public ListNode<T> next;

    public ListNode(T object) {
        this.object = object;
    }

    public String toString() {
        return object.toString();
    }
}


