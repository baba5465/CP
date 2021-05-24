package com.baba.Recursion;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]
                {
                        {3, 0, 6, 5, 0, 8, 4, 0, 0},
                        {5, 2, 0, 0, 0, 0, 0, 0, 0},
                        {0, 8, 7, 0, 0, 0, 0, 3, 1},
                        {0, 0, 3, 0, 1, 0, 0, 8, 0},
                        {9, 0, 0, 8, 6, 3, 0, 0, 5},
                        {0, 5, 0, 0, 9, 0, 6, 0, 0},
                        {1, 3, 0, 0, 0, 0, 2, 5, 0},
                        {0, 0, 0, 0, 0, 0, 0, 7, 4},
                        {0, 0, 5, 2, 0, 6, 3, 0, 0}
                };
        printBoard(board);

        solveSudoku(board, 0, 0, board.length);

        printBoard(board);
    }

    private static boolean solveSudoku(int[][] board, int i, int j, int n) {
        // Base case
        if (i == n) {
            return true;
        }

        // In case row end

        if (j == n) {
            return solveSudoku(board, i + 1, 0, n);
        }

        // Skip the pre-filled cell
        if (board[i][j] != 0) {
            return solveSudoku(board, i, j + 1, n);
        }

        // Checking all the numbers
        // Rec Case
        for (int number = 1; number <= 9; number++) {
            if (possible(board, i, j, n, number)) {
                board[i][j] = number;
                boolean canWeSolveNow = solveSudoku(board,i,j+1,n);
                if (canWeSolveNow){
                    return true;
                }
            }
        }

        // Backtrack here
        board[i][j] = 0;
        return false;
    }

    private static boolean possible(int[][] board, int i, int j, int n, int number) {
        // For column and row
        for (int t = 0; t < n; t++) {
            if (board[t][j] == number || board[i][t] == number) {
                return false;
            }
        }

        // For grid
        int sx = (i / 3) * 3;
        int sy = (j / 3) * 3;

        for (int t = sx; t < (sx + 3); t++) {
            for (int l = sy; l < (sy + 3); l++) {
                if (board[t][l] == number) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        for (int[] ints : board) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
