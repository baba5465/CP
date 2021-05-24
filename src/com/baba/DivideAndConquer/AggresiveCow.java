package com.baba.DivideAndConquer;

import java.util.Scanner;

public class AggresiveCow {
    /*
    Link for question and explanation : https://www.includehelp.com/data-structure-tutorial/aggressive-cows-on-binary-search.aspx
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int c = s.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++){
            arr[i] = s.nextInt();
        }
        System.out.println(search(arr, c));
    }

    private static int func(int n, int[] arr, int c) {
        int cows = 1, pos = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - pos >= n) {
                cows++;
                if (cows == c) {
                    return 1;
                }
                pos = arr[i];
            }
        }
        return 0;
    }

    private static int search(int[] arr, int c) {
        int low = 0;
        int high = arr[arr.length - 1];
        int max = -1;
        while (high > low) {
            int mid = (low + high) / 2;
            if (func(mid, arr, c) == 1) {
                if (mid > max) {
                    max = mid;
                }
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return max;
    }
}
