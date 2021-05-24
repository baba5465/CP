package com.baba.FenwickTree;

import java.util.Scanner;

public class InversionCountUsingBIT {
    private static int[] Bit = new int[10000];
    private static int[] arr = new int[10000];

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = s.nextInt();
        }
        int ans = 0;
        for (int i=n;i>=1; i--){
            ans += query(arr[i]-1);
            updateBIT(n,arr[i],1);
        }
        System.out.println(ans);
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
