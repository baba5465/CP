package com.baba.DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class DividingNumber {
    /*
    For a given number n, form a list and insert the following pattern into the
    list at the same position sequentially.
    {floor(n/2) , n%2 , floor(n/2) }
    Until every element in the list is either 1 or 0. Now, calculate number of 1s
    in from l to r (1-indexed).
    Input:
    9 6 9
    Output:
    3
    Example:
    9 will have the sequence : 101010111010101
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int l = s.nextInt();
        int r = s.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        divide(n,arr);
        System.out.println(Arrays.toString(arr.toArray()));
        int count = 0;
        for (int i=l; i<=r; i++){
            if (arr.get(i)==1){
                count++;
            }
        }
        System.out.println(count);
    }

    private static void divide(int n,ArrayList<Integer> arr){
        if (n==0){
            return;
        }
        divide(n/2,arr);
        if(n%2==0 || n%2==1){
            arr.add(n%2);
        }
        divide(n/2,arr);

    }
}
