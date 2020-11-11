package com.company.algorithms;

import java.util.Arrays;

public class QuickSort {
    public void quickSort(int[] A) {
        quickSort(A, 0, A.length-1); // roep quicksort aan met de (index) hoogste en laagste waarde van de lijst
    }

    private void quickSort(int[] A, int low, int high) { // recursie zit hier
        if (low < high + 1) {
            int pivot = partition(A, low,(low + high) /2, high);
            quickSort(A, low, pivot-1); // links van de pivot
            quickSort(A, pivot+1, high); // rechts van de pivot
        }
    }

    private int getPivot(int low, int middle, int high) { // mediaan "berekenen" util functie
        return (low + middle + high) / 3;
    }

    private void swap(int[] A, int index1, int index2) { // util functie om te swappen
    int temp = A[index1];
    A[index1] = A[index2];
    A[index2] = temp;
    }

    private int partition(int[] A, int low, int middle, int high) {
        swap(A, low, getPivot(low, middle, high));
        int border = low + 1;
        for(int i = border; i <= high; i++) {
            if(A[i] < A[low]) {
                swap(A, i, border++);
            }
        }
        swap(A, low, border-1);
        return border-1;

    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] array = {1,2,3,4,5,6,7,5,3,3,765,345,224,654,2,4,3,6,3,2,76,22,55,43,532,13,4,6,4,3,1,3,4,5};
        System.out.println(Arrays.toString(array));
        q.quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
