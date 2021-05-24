package com.baba.GreedyAlgorithm;

import java.util.Scanner;

public class BaisedStandingOptimized {
    /*
        Usually, results of competitions are based on the scores of participants.
        However, we are planning a change for the next year of IPSC. During the registration
        each team will be able to enter a single positive integer : their preferred place in the rank list.
        We would take all these preferences into account, and at the end of the competition we will simply
        announce a rank list that would please all of you.

        But wait... How would that rank list look like if it won't be possible to satisfy all the requests?

        Suppose that we already have a rank list. For each team, compute the distance between their preferred
        place and their place in the rank list. The sum of these distances will be called the badness of this rank list.
    */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int numberOfTeams = s.nextInt();
            int[] arr = new int[numberOfTeams + 1];
            for (int i = 0; i < numberOfTeams; i++) {
                String tName = s.next();
                int prefRank = s.nextInt();
                arr[prefRank]++;
            }
            int badness = 0;
            int rank = 1;
            for (int i = 1; i <= numberOfTeams; i++) {
                while (arr[i] > 0) {
                    badness += Math.abs(i - rank);
                    arr[i]--;
                    rank++;
                }
            }
            System.out.println(badness);
        }
    }
}
