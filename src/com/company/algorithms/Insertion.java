package com.company.algorithms;

import java.util.Arrays;

public class Insertion {
    public int[] insertionSort(int[] N) {
        int key, j, tmp;
        for (int i = 1; i < N.length; i++) {
            key = N[i];
            j = i - 1;
            while(j > -1 && key < N[j]) { // while (niet helemaal links && het getal groter is dan het getal links ervan
                tmp = N[j];
                N[j] = N[j + 1]; // SWAP
                N[j + 1] = tmp; // SWAP
                j--;
            }
            N[j + 1] = key;
        }
        return N;
    }


    private int[] reverse_insertion(int[] list) {
        int tmp, j, key;
        for(int i = 1; i < list.length; i++) {
            key = list[i];
            j = i - 1;
            while(j > -1 && key > list[j]) {
                tmp = list[j];
                list[j] = list[j + 1];
                list[j + 1] = tmp;
                j--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] array = {9,1,2,3,4,5,6,7,5,3,3,765,345,224,654,2,4,3,6,3,2,76,22,55,43,532,13,4,6,4,3,1,3,4,5};
        Insertion i = new Insertion();
        System.out.println(Arrays.toString(i.insertionSort(array)));

        int[] array2 = {9,1,2,3,4,5,6,7,5,3,3,765,345,224,654,2,4,3,6,3,2,76,22,55,43,532,13,4,6,4,3,1,3,4,5};
        System.out.println(Arrays.toString(i.reverse_insertion(array)));
    }
}
