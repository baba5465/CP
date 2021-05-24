package com.baba.SegmentTree;

import java.util.Arrays;
import java.util.Scanner;


public class SegmentTree {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int[] arr = {1, 3, 2, -5, 6, 4};
        int n = arr.length;

        /*
        Build the tree
         */
        int[] tree = new int[4 * n + 1];
        Arrays.fill(tree, Integer.MIN_VALUE);
        buildSegmentTree(arr, 0, n - 1, tree, 1);
        System.out.println(Arrays.toString(tree));

        System.out.println();

        /*
        Querying
         */
        int l = s.nextInt();
        int r = s.nextInt();

        System.out.println(query(tree, 0, n - 1, l, r, 1));

        System.out.println();

        /*
        Updating the index in the segment tree
         */
        updateNode(tree, 0, n - 1, 3, 15, 1);
        System.out.println(Arrays.toString(tree));

        /*
        Updating range in the segment tree
         */
        updateRange(tree,0,n-1,3,15,10,1);
        System.out.println(Arrays.toString(tree));
    }

    /*
    This function is used to build the segment tree.
    There can be 4*n+1 elements in segment tree in worst case therefore we take
    an array of 4*n+1 elements where n is the number of element of array from
    which we are making the tree.
    start = starting index of arr
    end = ending index of arr
    index = starting index of tree
     */
    private static void buildSegmentTree(int[] arr, int start, int end, int[] tree, int index) {
        if (start == end) {
            tree[index] = arr[start];
            return;
        }
        // Rec Case
        int mid = (start + end) / 2;

        buildSegmentTree(arr, start, mid, tree, 2 * index);
        buildSegmentTree(arr, mid + 1, end, tree, 2 * index + 1);

        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

    /*
    This function returns the minimum value in the given range
     */
    private static int query(int[] tree, int ss, int se, int qs, int qe, int index) {
        // Complete overlap
        if (ss >= qs && se <= qe) {
            return tree[index];
        }

        // No Overlap

        if (qe < ss || qs > se) {
            return Integer.MAX_VALUE;
        }

        // Partial Overlap

        int mid = (ss + se) / 2;
        int leftAns = query(tree, ss, mid, qs, qe, 2 * index);
        int rightAns = query(tree, mid + 1, se, qs, qe, 2 * index + 1);

        return Math.min(leftAns, rightAns);
    }

    /*
    Updating index in Segment Tree
     */
    private static void updateNode(int[] tree, int ss, int se, int i, int increment, int index) {
        /*
        We don't have to go out of the range
         */
        if (i > se || i < ss) {
            return;
        }

        /*
        Leaf Node
         */
        if (ss == se) {
            tree[index] += increment;
            return;
        }

        /*
        Left and Right Subtree
         */
        int mid = (ss + se) / 2;

        updateNode(tree, ss, mid, i, increment, 2 * index);
        updateNode(tree, mid + 1, se, i, increment, 2 * index + 1);
        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }

    /*
    Updating a range in segment tree
     */
    private static void updateRange(int[] tree, int ss, int se, int l, int r, int inc, int index) {
        //Out of bounds
        if (l > se || r < ss) {
            return;
        }

        // Leaf Node
        if (ss == se) {
            tree[index] += inc;
            return;
        }

        // Left and Right  Call Otherwise
        int mid = (ss + se) / 2;

        updateRange(tree, ss, mid, l, r, inc, 2 * index);
        updateRange(tree, mid + 1, se, l, r, inc, 2 * index + 1);

        tree[index] = Math.min(tree[2 * index], tree[2 * index + 1]);
    }
}
