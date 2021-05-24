package com.baba.BitManipulation;


import java.util.Scanner;

public class UniqueNumber {
    //    Given a list of numbers and all numbers occurs twice except one no. find that unique no.
//    n is always odd
    public static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        uniqueNumber3();
    }

    private static void uniqueNo1() {
        int n = s.nextInt();
        int unique = 0;
        for (int i = 0; i < n; i++) {
            unique = unique ^ s.nextInt();
        }
        System.out.println(unique);
    }

    private static void uniqueNo2() {
        int n = s.nextInt();
        int unique = 0;
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            int temp = s.nextInt();
            num[i] = temp;
            unique = unique ^ temp;
        }
        int pos = 0;
        int mask = 1;
        while ((unique & mask) == 0) {
            pos++;
            mask = mask << 1;
        }
        mask = 1 << pos;
        int res = unique;
        for (int i = 0; i < n; i++) {
            if ((mask & num[i]) > 0) {
                res = res ^ num[i];
            }
        }
        int res1 = unique ^ res;
        System.out.println(Math.min(res, res1) + " " + Math.max(res, res1));
    }

    private static void uniqueNumber3() {
        int n = s.nextInt();
        int[] arr = new int[64];
        for (int i = 0; i < n; i++) {
            int temp = s.nextInt();
            int j = 0;
            while (temp > 0) {
                arr[j] += (temp & 1);
                temp = temp >> 1;
                j++;
            }
        }
        int p = 1, sum = 0;
        for (int i = 0; i < 64; i++) {
            arr[i] %=3;
            sum += (arr[i]*p);
            p = p<<1;
        }
        System.out.println(sum);
    }
}
