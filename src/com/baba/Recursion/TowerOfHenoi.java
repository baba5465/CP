package com.baba.Recursion;

public class TowerOfHenoi {

    public static void main(String[] args) {
        toi(2, 'A', 'C', 'B');
    }

    /**
     * Tower Of Hanoi Problem Solution
     */
    private static void toi(int n, char src, char des, char helper) {
        if (n == 0) {
            return;
        }
        toi(n - 1, src, helper, des);
        System.out.println("Moving disk " + n + " from " + src + " to " + des);
        toi(n - 1, helper, des, src);
    }
}
