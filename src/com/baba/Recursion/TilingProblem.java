package com.baba.Recursion;

import java.util.Scanner;

public class TilingProblem {
    /*
    We are given a area of floor in the form of mXn find the minimum number of ways to fill the
    floor with the tile of dimension nX1 either by placing horizontally or vertically
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int m = s.nextInt();
            int n = s.nextInt();
            long[] dp = new long[m + 1];
            dp[0] = 1;
            for (int i = 1; i <= m; i++) {
                //Placing the tile vertically
                dp[i] = dp[i - 1];
                //Placing tile horizontally
                dp[i] += (i - n) >= 0 ? dp[i - n] : 0;
                dp[i] %= 1000000007;
            }
            System.out.println(dp[m]);
        }
    }
}
