package com.baba.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BusyManProblem {
    /*
    There is a busy man having many tasks to do. There is a list of tasks with start and end time
    we have to find the max task he can do.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int start, end;
        ArrayList<Pair> arr = new ArrayList<>();
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            for (int i = 0; i < n; i++) {
                start = s.nextInt();
                end = s.nextInt();
                arr.add(new Pair(start, end));
            }

            arr.sort(Comparator.comparingInt(Pair::getEnd));
            int ans = 1;
            int fin = arr.get(0).end;
            for (int i = 1; i < n; i++) {
                if (arr.get(i).start >= fin) {
                    ans++;
                    fin = arr.get(i).end;
                }
            }
            System.out.println(ans);
            arr.clear();
        }
    }

    static class Pair {
        private int start;
        private int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getEnd() {
            return end;
        }
    }
}
