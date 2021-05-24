package com.baba.Recursion;

import java.util.Scanner;

public class GeneratingParenthesis {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        printParenthesis(n, "", 0, 0);
    }

    private static void printParenthesis(int n, String ans, int close, int open) {

        if (close == n) {
            System.out.println(ans);
            return;
        }

        if (close < open) {
            printParenthesis(n, ans + ")", close + 1, open);
        }
        if (open < n) {
            printParenthesis(n, ans + "(", close, open + 1);
        }
    }
}
