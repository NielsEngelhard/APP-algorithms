package com.company.generics;

import java.util.ArrayList;

public class GenericsExcersices {

    public static String getSmallestItem(ArrayList<String> list) {
        String smallestItem = list.get(0);

        for(int i=1; i < list.size(); i++) {
            if(list.get(i).length() < smallestItem.length()) {
                System.out.println(list.get(i) + " is smaller then " + smallestItem);
                smallestItem = list.get(i);
            } else {
                System.out.println(list.get(i) + " is bigger then " + smallestItem);
            }
        }
        return smallestItem;
    }

    public static void main(String[] args) {
        ArrayList<String> l = new ArrayList<>();
        l.add("lol");
        l.add("koek");
        l.add("tenten");
        l.add("cool");
        l.add("j");
        System.out.println(getSmallestItem(l) + " is the smallest item");

    }
}
