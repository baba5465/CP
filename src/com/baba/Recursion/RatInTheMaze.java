package com.baba.Recursion;

import java.util.Scanner;

public class RatInTheMaze {
    private static int numberOfPath = 0;
    /*
    5 4
    OXOO
    OOOX
    OOXO
    XOOO
    XXOO
     */

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int m=s.nextInt();
        int n=s.nextInt();

        int[][] maze=new int[m][n];
        for(int i=0;i<m;i++)
        {
            String str=s.next();
            for(int k=0;k<str.length();k++) {
                char cc=str.charAt(k);
                if(cc=='X') {
                    maze[i][k]=1;
                }
            }
        }
        int[][] solution = new int[m][n];

        ratInMaze(maze, solution, 0, 0, m-1, n-1);

        System.out.println(numberOfPath);
    }

    private static boolean ratInMaze(int[][] maze, int[][] solution, int i, int j, int m, int n) {
        if (i == m && j == n) {
            solution[m][n] = 1;
            printSolution(solution);
            countPath();
            return true;
        }

        if (i > m || j > n) {
            return false;
        }

        if (maze[i][j] == 1) {
            return false;
        }

        solution[i][j] = 1;

        boolean rightSuccess = ratInMaze(maze, solution, i, j + 1, m, n);
        boolean downSuccess = ratInMaze(maze, solution, i + 1, j, m, n);

        // Backtracking
        solution[i][j] = 0;

        return rightSuccess || downSuccess;
    }

    private static void printSolution(int[][] solution) {
        for (int[] ints : solution) {
            for (int j = 0; j < solution[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void countPath() {
        numberOfPath++;
    }
}
