package com.baba.GreedyAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class DefenseOfKingdom {
    /*
        Theodore implements a new strategy game &ldquo;Defense of a Kingdom&rdquo;.
        On each level a player defends the Kingdom that is represented by a rectangular grid of cells.
        The player builds crossbow towers in some cells of the grid. The tower defends all the cells
        in the same row and the same column. No two towers share a row or a column.

        The penalty of the position is the number of cells in the largest undefended rectangle.
        For example, the position shown on the picture has penalty 12.

        {@link}: https://www.spoj.com/problems/DEFKIN/}
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int width = s.nextInt();
            int height = s.nextInt();
            int noOfCrossbow = s.nextInt();
            int[] x = new int[noOfCrossbow];
            int[] y = new int[noOfCrossbow];
            for (int i = 0; i < noOfCrossbow; i++) {
                x[i] = s.nextInt();
                y[i] = s.nextInt();
            }
            /*
            First we sort the coordinates of x and y and then calculate the max distance between every
            tower and for the edge cases find max between start and first tower or end and last tower
            */
            Arrays.sort(x);
            Arrays.sort(y);
            int dx = x[0] - 1;
            int dy = y[0] - 1;
            for (int i = 1; i < noOfCrossbow-1; i++) {
                dx = Math.max(dx, x[i] - x[i - 1] - 1);
                dy = Math.max(dy, y[i] - y[i - 1] - 1);
            }
            dx = Math.max(dx, width - x[noOfCrossbow - 1]);
            dy = Math.max(dy, height - y[noOfCrossbow - 1]);
            /*
            At last we print the max area by multiplying max of x and max of y
             */
            System.out.println(dx * dy);
        }
    }
}
