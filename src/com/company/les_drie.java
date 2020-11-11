package com.company;

public class les_drie {

    private static void printArray(int[] array) {
        for(int number : array) {
            System.out.println(number);
        }
    }

    // opdracht 8.1 a INSERTION SORT
    public int[] quick_sort(int[] N) {
        for (int i = 1; i < N.length; i++) {
            int toBeInserted = N[i];
            int j = i;

            while ( (j > 0) && (toBeInserted < N[j - 1])) {
                N[j] = N[j - 1];
                j--;
            }
            N[j] = toBeInserted;
        }
        return N;
    }

    private static void merge(int[] list, int lowIndex, int midIndex, int highIndex) {
        int[] L = new int[midIndex - lowIndex + 2];

        for (int i = lowIndex; i <= midIndex; i++) {
            L[i - lowIndex] = list[i];
        }
        L[midIndex - lowIndex + 1] = Integer.MAX_VALUE;
        int[] R = new int[highIndex - midIndex + 1];

        for (int i = midIndex + 1; i <= highIndex; i++) {
            R[i - midIndex - 1] = list[i];
        }
        R[highIndex - midIndex] = Integer.MAX_VALUE;
        int i = 0, j = 0;

        for (int k = lowIndex; k <= highIndex; k++) {
            if (L[i] <= R[j]) {
                list[k] = L[i];
                i++;
            }
            else {
                list[k] = R[j];
                j++;
            }
        }
    }

    // opdracht 8.1 c MERGE SORT
    public static void mergeSort(int[] list, int lowestIndex, int highestIndex) {
        if (lowestIndex == highestIndex) { // base case (if there is only 1 item in the seperated "list")
            return;
        } else { // more seperating
            int midIndex = (lowestIndex + highestIndex) / 2; // middle is always highest+lowest divided by 2
            mergeSort(list, lowestIndex, midIndex); // call itself for making new list (left from mid)
            mergeSort(list, midIndex + 1, highestIndex); // call itself for making new list (right from mid)
            merge(list, lowestIndex, midIndex + 1, highestIndex);
        }
    }

//    public static void merge(int[] list, int lowestIndex, int midIndex, int highestIndex) {
//
//    }





    // opdracht 8.1 d QUICK SORT

    public static void main(String[] args) {
        int[] example_population = {8, 1, 4, 1, 5, 9, 2, 6, 5};
        les_drie l = new les_drie();

        les_drie.mergeSort(example_population, 0,  example_population.length - 1); //- 1 arrays start at 0
//        // TIME O(N²) - snel voor kleine arrays
//        // INSERTION SORT BEFORE
//        System.out.println("before insertion sort: ");
//        for (int value : example_population) {
//            System.out.println(value);
//        }
//
//        // INSERTION SORT AFTER
//        System.out.println("after insertion sort: ");
//        for (int value : l.quick_sort(example_population)) {
//            System.out.println(value);
//        }
    }
}
