package com.baba.Recursion;


import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 6, 9, 21, 0, 2, 32, 12, 23};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void merge(int[] arr, int low, int high) {
        int mid = (low + high) / 2;

        int n1 = mid - low + 1;
        int n2 = high - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.arraycopy(arr, low, L, 0, n1);

        System.arraycopy(arr, mid + 1, R, 0, n2);

        int i = 0, j = 0;
        int k = low;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
            }
        }

        while (i < n1) arr[k++] = L[i++];

        while (j < n2) arr[k++] = R[j++];
    }

    private static void mergeSort(int[] arr, int low, int high) {
        /*
          First Check if lowest index is greater than highest if so then return
         */
        if (low < high) {
            /*
              Now we divide the array in two parts from low to mid and mid +1 to high recursively
              And we keep doing it until all the elements got separated
             */
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);

            mergeSort(arr, mid + 1, high);
            /*
              Now we merge the elements by sorting them
             */
            merge(arr, low, high);
        }
    }
}
