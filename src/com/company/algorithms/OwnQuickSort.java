package com.company.algorithms;

public class OwnQuickSort {
    private int getPivot(int left, int mid, int right) { // util function
        return (left + mid + right ) / 3;
    }

    public void quickSort(int[] N) {
        quickSort(N, 0, N.length - 1);
    }

    public void quickSort(int[] list, int low, int high) {
        if (low < high + 1) {
            int pivot = partition(list, low, (low + high) / 2, high);
            quickSort(list, low, pivot - 1);
            quickSort(list, pivot + 1, high);
        }
    }

    private int partition(int[] list, int low, int middle, int high) {
        swap(list, high, getPivot(low, middle, high));
        int border = low + 1;
        for(int i = border; i <= high; i++) {
            if(list[i] < list[low]) {
                swap(list, i, border++);
            }
        }
        swap(list, low, border - 1);
        return border - 1;
    }

    private void swap(int[] list, int index1, int index2) {
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }
}
