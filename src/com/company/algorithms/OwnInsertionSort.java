package com.company.algorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class OwnInsertionSort {
    public static  int[] doInsertionSort(int[] list) {
        int key, j;
        for(int i = 1; i < list.length; i++) {
            key = list[i];
            j = i - 1;
            while(j > -1 && key < list[j]) {
                int temp = list[j];
                list[j] = list[j + 1]; // schuift naar rechts op
                list[j] = temp;       // en de j wordt dus vervangen
                j--;
            }
            list[j + 1] = key;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] lol = {5,3,4,55,3,2};
        System.out.println(Arrays.toString(doInsertionSort(lol)));
    }
}
