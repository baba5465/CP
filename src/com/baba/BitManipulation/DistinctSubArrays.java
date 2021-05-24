package com.baba.BitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class DistinctSubArrays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(s.nextInt());
        }
        HashSet<Integer> set = new HashSet<>();
        int sum=0;
        int i, j=0;
        for (i=0; i<n; i++){
            while (j<n && !set.contains(arr.get(j))){
                set.add(arr.get(j));
                j++;
            }
            sum += (j-i)*(j-i+1)/2;
            set.remove(arr.get(i));
        }
        System.out.println(sum);
    }
}
