package com.baba.Recursion;

import java.util.Scanner;

public class CountNumberOfBinaryStrings {
    /*
    Count the all possible
    distinct binary strings of length N
    such that there are no consecutive 1’s
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            int[][] dp = new int[n + 1][2];
            dp[1][0] = 1;
            dp[1][1] = 1;
            for (int i = 2; i <= n; i++) {
                dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
                dp[i][1] = dp[i - 1][0];
            }
            System.out.println(dp[n][0] + dp[n][1]);
        }
    }
}