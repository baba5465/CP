package com.baba.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class BaisedStandingProblem {
    /*
        Usually, results of competitions are based on the scores of participants.
        However, we are planning a change for the next year of IPSC. During the registration
        each team will be able to enter a single positive integer : their preferred place in the ranklist.
        We would take all these preferences into account, and at the end of the competition we will simply
        announce a ranklist that would please all of you.

        But wait... How would that ranklist look like if it won't be possible to satisfy all the requests?

        Suppose that we already have a ranklist. For each team, compute the distance between their preferred
        place and their place in the ranklist. The sum of these distances will be called the badness of this ranklist.
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        ArrayList<Team> arr = new ArrayList<>();
        while (t-- > 0) {
            int numberOfTeams = s.nextInt();
            for (int i = 0; i < numberOfTeams; i++) {
                String tName = s.next();
                int prefRank = s.nextInt();
                arr.add(new Team(tName,prefRank));
            }
            arr.sort(Comparator.comparingInt(Team::getPreferredRank));
            int badness = 0;
            int initRank = 1;
            for (Team team : arr){
                badness += Math.abs(team.preferredRank-initRank);
                initRank++;
            }
            arr.clear();
            System.out.println(badness);
        }
    }

    static class Team {
        private String teamName;
        private int preferredRank;

        public Team(String teamName, int preferredRank) {
            this.teamName = teamName;
            this.preferredRank = preferredRank;
        }

        public String getTeamName() {
            return teamName;
        }

        public int getPreferredRank() {
            return preferredRank;
        }
    }
}
