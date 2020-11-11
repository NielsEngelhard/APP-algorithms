package com.company.algorithms;

import java.util.Arrays;

public class OwnMergeSort {

    public int[] mergeSort(int[] N) {
        System.out.println("input: " + Arrays.toString(N));
        return mergeSort(N, 0, N.length - 1);
    }

    private int[] mergeSort(int[] list, int lowest, int highest) {
        int[] output = {};
        if(list.length > 1) { // base case
            int mid = (lowest + highest) / 2;
            int[] left = Arrays.copyOfRange(list, lowest, mid);
            System.out.println("array gesplits links: " + Arrays.toString(left));
            left = mergeSort(left, 0, mid);

            int[] right = Arrays.copyOfRange(list, mid, highest);
            System.out.println("array gesplits rechts: " + Arrays.toString(right));
            right = mergeSort(right, 0, mid);
            System.out.println("array gesplits rechts: " + Arrays.toString(right));
//            int[] left = mergeSort(Arrays.copyOfRange(list, lowest, mid), lowest, mid); // links
//            int[] right = mergeSort(Arrays.copyOfRange(list, mid + 1, highest), mid + 1, highest); // rechts
            output = merge(left, right);
        }
        return output;
    }

    private int[] merge(int[] array_a, int[] array_b) {
        int[] array_c = new int[array_a.length + array_b.length]; // want array C is een combinatie van A + B
        int index_a = 0, index_b = 0, index_c = 0;
        while(index_a < array_a.length && index_b < array_b.length) {
            if(array_a[index_a] <= array_b[index_b]) { // als A kleiner of gelijk is voeg deze toe
                array_c[index_c] = array_a[index_a];
                index_a++;
                index_c++;
            } else { // als B dus kleiner is wordt deze toegevoegd
                array_c[index_c] = array_b[index_b];
                index_b++;
                index_c++;
            }
        }
        while(index_a < array_a.length) {
            array_c[index_c] = array_a[index_a];
            index_a++;
            index_c++;
        }

        while(index_b < array_b.length) {
            array_c[index_c] = array_b[index_b];
            index_b++;
            index_c++;
        }
        return array_c;
    }

    public static void main(String[] args) {
        int[] N = {1,2,23,4,5,65,54,3,32,54,6,3,2,5,634,3,65,5,3,5,6,3,3};
        OwnMergeSort oms = new OwnMergeSort();
        System.out.println(Arrays.toString(oms.mergeSort(N)));
    }
}
