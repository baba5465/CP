package com.baba.DynamicProgramming;

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

    public static void main(String[] args) {
        HashSet<String> dict = new HashSet<>();
        dict.add("this");
        dict.add("is");
        dict.add("sumit");
        dict.add("jain");
        dict.add("the");
        dict.add("problem");
        String s = "thisissumitjain";

        HashSet<String> dp = new HashSet<>();

        find(s, dict, dp, "");
    }

    private static boolean find(String str, HashSet<String> dict, HashSet<String> dp, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return true;
        }else if (dp.contains(str)){
            return false;
        }else {
            int index = 0;
            String word = "";
            while (index<str.length()){
                word += str.charAt(index);
                if (dict.contains(word)){
                    if (find(str.substring(index+1),dict,dp,ans+word+" ")){
                        return true;
                    }else {
                        index++; // backtrack
                    }
                }else {
                    index++;
                }
            }
        }
        dp.add(str);
        return false;
    }
}
