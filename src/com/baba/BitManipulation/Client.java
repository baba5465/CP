package com.baba.BitManipulation;

public class Client {
    private static void doCalc(byte... a) {
        System.out.print("byte...");
    }

    private static void doCalc(long a) {
        System.out.print("long, long");
    }

    private static void doCalc(Byte s1, Byte s2) {
        System.out.print("Byte, Byte");
    }

    public static void main(String[] args) {
        byte b = 5;
        int a = 0;
        //doCalc(b, b);
        doCalc(b, b);
    }
}