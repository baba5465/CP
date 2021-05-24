package com.baba.DivideAndConquer;

public class SquareRootBS {
    public static void main(String[] args) {
        System.out.println(squareRoot(10, 4));
        System.out.println(squareRoot(49, 3));
    }

    private static float squareRoot(int number, int places) {
        int start = 0;
        int end = number;
        float ans = 0.0f;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid * mid == number) {
                return mid;
            }
            if (mid * mid > number) {
                end = mid - 1;
            } else {
                ans = mid;
                start = mid + 1;
            }
        }

        // Fractional part
        float inc = 0.1f;
        for (int i = 0; i < places; i++) {
            while (ans * ans <= number) {
                ans += inc;
            }
            ans = ans - inc;
            inc /= 10;
        }
        return ans;
    }
}

// Complexity O(log(n) + p)
