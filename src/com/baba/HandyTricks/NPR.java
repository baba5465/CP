package com.baba.HandyTricks;

public class NPR {
    public static void main(String[] args) {
        System.out.println(nPr(15, 12));
    }

    private static long nPr(long n, long r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res *= (n - i);
        }
        return res;
    }
}
