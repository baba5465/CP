package com.baba.Recursion;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;
        int[][] board = new int[n][n];
        solveNQueen(board, 0, n);
        printBoard(board, n);
    }

    private static boolean solveNQueen(int[][] board, int i, int n) {
        // Here i = current row and n = no. of rows
        // Base case
        if (i == n) {
            // Successfully placed queens in n rows
            // Print the board
            return true;
        }

        // Recursive Case
        // Try to place the queen on current row and call the remaining
        // part which is solved by recursion
        for (int j = 0; j < n; j++) {
            // We have to check if the i,j th place is safe for queen or
            // not
            if (isSafe(board, i, j, n)) {
                // We place the queen
                board[i][j] = 1;

                // Now we check if we able to place next queen
                if (solveNQueen(board, i + 1, n)) {
                    return true;
                }
                // If we are here means the position of queen is not safe
                board[i][j] = 0; // Backtrack

            }
        }

        return false;
    }

    private static boolean isSafe(int[][] board, int i, int j, int n) {
        // We can check for column
        for (int row = 0; row < i; row++) {
            if (board[row][j] == 1) {
                return false;
            }
        }

        // Now we check for left diagonal
        int x = i;
        int y = j;

        while (x >= 0 && y >= 0) {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y--;
        }
        // Now we check for right diagonal
        x = i;
        y = j;
        while (x >= 0 && y < n) {
            if (board[x][y] == 1) {
                return false;
            }
            x--;
            y++;
        }

        // Now if all are fine then position is safe and we return true
        return true;
    }

    private static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}
