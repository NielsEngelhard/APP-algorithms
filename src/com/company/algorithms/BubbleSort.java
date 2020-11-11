package com.company.algorithms;

import java.util.Arrays;

public class BubbleSort { // BIG O : O(N²)
    // gebruikt nested loops.
    // niet efficient
    // alleen gebruiken bij kleine data sets.

    public int[] bubbleSort(int[] list) {
        int i, j, temp = 0;
        for(i=0; i < list.length - 1; i++) {
            for(j=0; j < list.length - 1; j++) {
                if(list[j] > list[j + 1]) { // is ie groter dan degene rechts naast
                    temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        BubbleSort b = new BubbleSort();
        int[] list = {1,2,3,4,5,32,1,23,3,5,2,9};
        b.bubbleSort(list);
        System.out.println(Arrays.toString(list));
    }
}
