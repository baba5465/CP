package com.baba.BitManipulation;

import java.util.Scanner;

public class ReplaceMBitsInN {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int M = s.nextInt();
        int i = s.nextInt();
        int j = s.nextInt();
        System.out.println(Integer.toBinaryString(N));
        System.out.println(Integer.toBinaryString(M));
        N = clearRangeIToJBits(N, j-1, i-1);
        System.out.println(Integer.toBinaryString(N));
        M = M << i;
        int ans = N | M;
        System.out.println(Integer.toBinaryString(ans));
    }

    private static int clearRangeIToJBits(int n, int j, int i) {
        int a = -1 << (j + 1);
        int b = (1 << i) - 1;
        int mask = a | b;
        return n & mask;
    }
}
