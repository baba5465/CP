package com.baba.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class ConnectingWires {
    /*
    The are two types of wire white and black you have to connect two wires one black and one white
    such that the length of connecting the wire is minimum
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numberOfWires = s.nextInt();
        int[] white = new int[numberOfWires];
        int[] black = new int[numberOfWires];
        for (int i = 0; i < numberOfWires; i++) {
            white[i] = s.nextInt();
        }
        for (int i = 0; i < numberOfWires; i++) {
            black[i] = s.nextInt();
        }
        Arrays.sort(white);
        Arrays.sort(black);
        int ans = 0;
        for (int i = 0; i < numberOfWires; i++) {
            ans += Math.abs(white[i] - black[i]);
        }
        System.out.println(ans);
    }
}
