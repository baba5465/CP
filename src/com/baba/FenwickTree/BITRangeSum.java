package com.baba.FenwickTree;

import java.util.Scanner;

public class BITRangeSum {
    private static int[] Bit = new int[10000];
    private static int[] arr = new int[10000];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = s.nextInt();
            updateBITForMax(n, i, arr[i]);
        }
        int q = s.nextInt();
        while (q-- > 0) {
            int i = s.nextInt();
            System.out.println(rangeMaxQuery(i));
        }
    }

    private static void updateBITForMax(int n, int i, int val) {
        while (i <= n) {
            Bit[i] = Math.max(Bit[i], val);
            i += i & (-i);
        }
    }

    //Max element till the index
    private static int rangeMaxQuery(int i) {
        int ans = 0;
        while (i > 0) {
            ans = Math.max(ans, Bit[i]);
            i -= i & (-i);
        }
        return ans;
    }
}
