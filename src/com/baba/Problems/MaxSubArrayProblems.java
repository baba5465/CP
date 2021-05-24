package com.baba.Problems;

import java.util.Arrays;

public class MaxSubArrayProblems {

    public static void main(String[] args) {

        int[] A = new int[]{13, -3, -25, 20, -3, -16, -23, 18, 20, -1, 12, -5, -22, 15, -4, 7};
        int[] res = maxSubArray(A, 0, A.length - 1);
        System.out.println(Arrays.toString(res));
    }

    private static int[] maxSubArray(int[] A, int low, int high) {
        if (high == low) {
            return new int[]{low, high, A[low]};
        }
        int mid = (low + high) / 2;
        int[] leftSubArray = maxSubArray(A, low, mid);
        int[] rightSubArray = maxSubArray(A, mid + 1, high);
        int[] crossSubArray = crossingSubArray(A, low, mid, high);
        if (leftSubArray[2] >= rightSubArray[2] && leftSubArray[2] >= crossSubArray[2]) {
            return leftSubArray;
        } else if (rightSubArray[2] >= leftSubArray[2] && rightSubArray[2] >= crossSubArray[2]) {
            return rightSubArray;
        } else {
            return crossSubArray;
        }
    }

    private static int[] crossingSubArray(int[] A, int low, int mid, int high) {
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int maxLeft = 0;
        int maxRight = 0;
        for (int i = mid; i >= low; --i) {
            sum += A[i];
            if (sum > leftSum) {
                leftSum = sum;
                maxLeft = i;
            }
        }
        sum = 0;
        for (int i = mid + 1; i <= high; ++i) {
            sum += A[i];
            if (sum > rightSum) {
                rightSum = sum;
                maxRight = i;
            }
        }
        return new int[]{maxLeft, maxRight, leftSum + rightSum};
    }
}
