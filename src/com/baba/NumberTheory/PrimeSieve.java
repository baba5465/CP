package com.baba.NumberTheory;

import java.util.Scanner;

public class PrimeSieve {

    public static void main(String[] args) {
        /*
          Prime Sieve for prime numbers
         */
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n + 1];
        for (int i = 3; i < arr.length; i += 2) {
            arr[i] = 1;
        }
        for (int i = 3; i * i < arr.length; i += 2) {
            if (arr[i] == 1) {
                for (int j = i * i; j < arr.length; j += i) {
                    arr[j] = 0;
                }
            }
        }
        arr[2] = 1;
        arr[0] = arr[1] = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.print(i + " ");
            }
        }
    }
}
