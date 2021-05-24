package com.baba.BitManipulation;

public class CommonBitOperations {
    public static void main(String[] args) {
        System.out.println("5 = " + Integer.toBinaryString(5));
        System.out.println("1 = " + Integer.toBinaryString(1));
        System.out.println("9 = " + Integer.toBinaryString(9));
        System.out.println("250 = " + Integer.toBinaryString(250));
        System.out.println(Integer.toBinaryString(getBitAtPosition(5, 0)));
        System.out.println(Integer.toBinaryString(setBitAtPosition(1, 2)));
        System.out.println(Integer.toBinaryString(clearBitAtPosition(5, 2)));
        System.out.println(Integer.toBinaryString(updateBitAtPosition(9, 3, 0)));
        System.out.println(Integer.toBinaryString(clearLastIBits(9, 3)));
        System.out.println(Integer.toBinaryString(clearRangeIToJBits(250, 5, 2)));
    }

    private static int getBitAtPosition(int n, int position) {
        int mask = 1 << position;//It generates a number needed for AND to get the bit
        int bit = (n & mask) > 0 ? 1 : 0;
        return bit;
    }

    private static int setBitAtPosition(int n, int position) {
        int mask = 1 << position;
        return n | mask;
    }

    private static int clearBitAtPosition(int n, int position) {
        int mask = ~(1 << position);
        return n & mask;
    }

    private static int updateBitAtPosition(int n, int position, int v) {
        n = clearBitAtPosition(n, position);
        int mask = v << position;
        return n | mask;
    }

    private static int clearLastIBits(int n, int i) {
        int mask = -1 << i;
        return n & mask;
    }

    private static int clearRangeIToJBits(int n, int j, int i) {
        int a = -1 << (j + 1);
        int b = (1 << i) - 1;
        int mask = a | b;
        return n & mask;
    }
}
