package com.baba.DivideAndConquer;

import java.util.Scanner;

public class BookAllocationProblem {
    /*
    There are n books with P(i) pages in book where 0<= i < n
    and k number of students. Our task is to divide the books among the k student
    so that maximize the minimum no. of pages among students
     */
    private static int sum = 0;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int[] books = new int[n];
        for (int i = 0; i < n; i++) {
            books[i] = s.nextInt();
            sum += books[i];
        }
        System.out.println(binarySearchBook(books, n, k));
    }

    private static int binarySearchBook(int[] books, int n, int k) {
        int start = books[books.length - 1];
        int end = sum;
        int ans = start;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (isValidConfig(books, n, k, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isValidConfig(int[] books, int n, int k, int ans) {
        int student = 1;
        int currentPages = 0;
        for (int i = 0; i < n; i++) {
            if ((currentPages + books[i]) > ans) {
                currentPages = books[i];
                student++;
                if (student > k) {
                    return false;
                }
            } else {
                currentPages += books[i];
            }
        }
        return true;
    }
}
