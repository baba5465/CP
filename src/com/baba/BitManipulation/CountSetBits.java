package com.baba.BitManipulation;

public class CountSetBits {
    public static void main(String[] args) {
        //Method 1
        System.out.println(countBits(9));
        //Method 2
        System.out.println(countBits1(9));
        //Method 3
        System.out.println(Integer.bitCount(9));
    }

    private static int countBits(int n) {
        int mask = 1;
        int count = 0;
        while (n > 0) {
            count += n&mask;
            n = n>>1;
        }
        return count;
    }

    private static int countBits1(int n) {
        int count=0;
        while (n > 0) {
            n = n&(n-1);
            count++;
        }
        return count;
    }
}
