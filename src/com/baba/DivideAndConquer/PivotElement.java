package com.baba.DivideAndConquer;

public class PivotElement {
    /*
    Find index of greatest element in sorted and rotated array
     */
    public static void main(String[] args) {
        int[] arr = {9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(binarySearch(arr));
    }

    private static int binarySearch(int[] arr) {
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
}
