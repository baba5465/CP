package com.baba.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Chopsticks {
    /*
     {@link} : https://www.codechef.com/problems/TACHSTCK
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long d = s.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextLong();
        }
        Arrays.sort(arr);
        int ans = 0;
        for (int i=1; i<n;){
            if (arr[i]-arr[i-1]<=d){
                i+=2;
                ans++;
            }else {
                i++;
            }
        }
        System.out.println(ans);
    }
}
