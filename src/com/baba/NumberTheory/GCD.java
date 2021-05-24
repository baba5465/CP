package com.baba.NumberTheory;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        /*
          Euclid's Algorithm for GCD and LCM
         */
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.println("GCD : " + gcd(a, b));
        System.out.println("LCM : " + lcm(a, b));
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
}
