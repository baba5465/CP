package com.baba.Recursion;

import java.util.Scanner;

public class KnightInChessBoardProblem {
    /*
    There is knight in a chess board which can move only position having 1 and not having 0.
    We have to find out the number of places it can't move.
     */
    private static int hi;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[][] board = new int[n][n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = s.nextInt();
                if (board[i][j] == 1) {
                    sum++;
                }
            }
        }
        solve(board, sum);
    }

    private static void set(int[][] board, int i, int j, int count) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 0) {
            return;
        }
        board[i][j] = 0;// unset the (i,j) cell
        hi = Math.max(hi, count + 1);// hi stores the maximum of value of visited squares
        // try all 8 possible moves for knight
        set(board, i - 1, j - 2, count + 1);
        set(board, i - 2, j - 1, count + 1);
        set(board, i + 1, j - 2, count + 1);
        set(board, i + 2, j - 1, count + 1);
        set(board, i - 1, j + 2, count + 1);
        set(board, i - 2, j + 1, count + 1);
        set(board, i + 1, j + 2, count + 1);
        set(board, i + 2, j + 1, count + 1);

        board[i][j] = 1; // sets (i,j) cell again(backtracking)
    }

    private static void solve(int[][] board, int sum) {
        hi = 0;
        set(board, 0, 0, 0);
        System.out.print(sum - hi);
    }
}
