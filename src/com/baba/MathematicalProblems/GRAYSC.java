package com.baba.MathematicalProblems;

import java.util.ArrayList;
import java.util.Scanner;

public class GRAYSC {
    public static void main(String[] args) {
        // GRAYSC code chef

        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        if (n >= 130) {
            System.out.println("Yes");
            return;
        }
        ArrayList<Long> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(s.nextLong());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    for (int l = k + 1; l < n; l++) {
                        if ((arr.get(i)^arr.get(j)^arr.get(k)^arr.get(l))==0){
                            System.out.println("Yes");
                            return;
                        }
                    }
                }
            }
        }
        System.out.println("No");
    }
}
