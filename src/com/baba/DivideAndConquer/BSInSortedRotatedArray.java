package com.baba.DivideAndConquer;

public class BSInSortedRotatedArray {
    public static void main(String[] args) {
        int[] arr = {9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1, 2, 3, 4, 5, 6, 7, 8};
        int high = binarySearchPivot(arr);
        int key = 90;
        int ans;
        if (key <= arr[high] && key >= arr[0]) {
            ans = binarySearch(arr, key, 0, high);
        } else {
            ans = binarySearch(arr, key, high + 1, arr.length - 1);
        }
        System.out.println(ans);
    }

    private static int binarySearchPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (mid > start && arr[mid] < arr[mid - 1]) {
                ans = mid - 1;
                break;
            }
            if (mid < end && arr[mid] > arr[mid + 1]) {
                ans = mid;
                break;
            }
            if (arr[end] <= arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return ans == -1 ? arr.length - 1 : ans;
    }

    private static int binarySearch(int[] arr, int key, int start, int end) {
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
