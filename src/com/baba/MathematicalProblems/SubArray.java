package com.baba.MathematicalProblems;

import java.util.Scanner;

public class SubArray {

    public static void main(String[] args) {
        //No. of sub arrays whose sum is divisible by n(where n is the no. of elements in array)

        Scanner s = new Scanner(System.in);

        long t = s.nextInt();
        for (long i = 0; i < t; i++) {
            int n = s.nextInt();
            long[] arr = new long[n];
            arr[0] = 1L;
            int sum = 0;
            for (long j = 0; j < n; j++) {
                long x = s.nextLong();
                sum += x;
                sum %= n;
                sum = (sum + n) % n;
                arr[sum]++;
            }
            long ans = 0;
            for (int j = 0; j < n; j++) {
                ans += (arr[j] * (arr[j] - 1)) / 2;
            }
            System.out.println(ans);
        }
    }
}
