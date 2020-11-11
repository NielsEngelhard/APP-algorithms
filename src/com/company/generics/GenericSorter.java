package com.company.generics;

public class GenericSorter {

    // 2.24
    public <T extends Comparable<? super T>> T min(T[] list) {
        T smallestItem = list[0];

        for(int i = 1; i < list.length; i++) {
            if(list[i].compareTo(smallestItem) < 0) {
                smallestItem = list[i];
            }
        }
        return smallestItem;
    }

    public static void main(String[] args) {
        String[] l = {"Niels", "Chris", "Michel", "Jasmijn", "Dave", "Bob", "Jannn"};

        GenericSorter g = new GenericSorter();

        System.out.println(g.min(l));
    }
}
