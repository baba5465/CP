package com.baba.FenwickTree;

import java.util.Scanner;

public class BIT {
    /*
    BIT(Binary Indexed Tree) or Fenwick Tree
     */
    private static int[] Bit = new int[10000];
    private static int[] arr = new int[10000];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = s.nextInt();
            updateBIT(n, i, arr[i]);
        }
        int q = s.nextInt();
        while (q-- > 0) {
            int l = s.nextInt();
            int r = s.nextInt();
            System.out.println(query(r) - query(l - 1));
        }
    }

    private static void updateBIT(int n, int i, int val) {
        while (i <= n) {
            Bit[i] += val;
            i += i & (-i);
        }
    }

    //Sum till the ith index
    private static int query(int i) {
        int ans = 0;
        while (i > 0) {
            ans += Bit[i];
            i -= i & (-i);
        }
        return ans;
    }
}
