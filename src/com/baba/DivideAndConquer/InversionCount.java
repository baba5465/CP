package com.baba.DivideAndConquer;

public class InversionCount {
    /*
    If there is an array such that for any two index i and j, where i<j and a[i]>a[j] then
    this is called inversion. We have to count all those pairs.

    Point to Remember : It means if an array is sorted then there is no inversion.
     */
    private static int count = 0;

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 2, 3, 7};
        inversionCount(arr, 0, arr.length - 1);
        System.out.println(count);
    }

    private static void inversionCount(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            inversionCount(arr, low, mid);
            inversionCount(arr, mid + 1, high);

            inversionCountHelper(arr, low, high);
        }
    }

    private static void inversionCountHelper(int[] arr, int low, int high) {
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
            if (L[i] < R[j]) {
                arr[k++] = L[i++];
            } else {
                count += mid + 1 - i;
                arr[k++] = R[j++];
            }
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }
}
