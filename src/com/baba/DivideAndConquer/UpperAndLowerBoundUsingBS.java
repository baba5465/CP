package com.baba.DivideAndConquer;

public class UpperAndLowerBoundUsingBS {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 7, 8, 8, 9};
        int key = 3;
        System.out.println(lowerBound(arr, key));
        System.out.println(upperBound(arr, key));
    }

    private static int lowerBound(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                ans = mid;
                end = mid - 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return ans;
    }

    private static int upperBound(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] == key) {
                ans = mid;
                start = mid + 1;
            } else if (arr[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }

        }
        return ans;
    }
}
