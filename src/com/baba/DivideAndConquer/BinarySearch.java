package com.baba.DivideAndConquer;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int key = 9;
        System.out.println(binarySearch(arr, key, 0, arr.length - 1));
        System.out.println(binarySearch(arr, key));
    }

    // Recursive

    private static int binarySearch(int[] arr, int key, int low, int high) {
        int mid = (high + low) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (low < high) {
            if (key < arr[mid]) {
                return binarySearch(arr, key, low, mid - 1);
            } else if (key > arr[mid]) {
                return binarySearch(arr, key, mid + 1, high);
            }
        }
        return -1;
    }

    // Iterative

    private static int binarySearch(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}
