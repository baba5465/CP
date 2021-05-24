package com.baba.Backtracking;

import java.util.HashSet;

public class WordCount {
    /*
        Given an string and a dictionary of words, find out if the input string can be
        broken into a space-separated sequence of one or more dictionary words.

        dictionary = ["I" , "have", "Jain", "Sumit", "am", "this", "dog"]

        String = "IamSumit"

        Output: "I am Sumit"

        String ="thisisadog"

        Output : String can't be broken
    */
    /*
    Naive approach backtracking
    Now see the Dynamic Programming package for optimal solution because this problem contains
    overlapping sub problems so it can be solved by DP efficiently
    */
    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("this");
        dict.add("is");
        dict.add("sumit");
        dict.add("jain");
        dict.add("the");
        dict.add("problem");
        String s = "thisissumitjain";

        wordBreak(s, dict);
    }

    private static void wordBreak(String str, HashSet<String> dict) {
        if (!find(str, dict, "")) {
            System.out.println("Can't break the string");
        }
    }

    private static boolean find(String str, HashSet<String> dict, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return true;
        } else {
            int index = 0;
            String word = "";
            while (index < str.length()) {
                word += str.charAt(index);
                if (dict.contains(word)) {
                    if (find(str.substring(index + 1), dict, ans + word + " ")) {
                        return true;
                    } else {
                        index++; //Backtrack
                    }
                } else {
                    index++;
                }
            }
        }
        return false;
    }
}
