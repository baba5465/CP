package com.baba.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CodesOfString {
    /*
    Take as input str, a string. Assume that value of a=1, b=2, c=3, d=4, …. z=26.
    Write a recursive function (return type ArrayList) to print all possible codes
    for the string. E.g. for “1123” possible codes are aabc, kbc, alc, aaw, kw.
     */

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();
        System.out.println(Arrays.toString(codeOfString(str).toArray()));
    }

    private static ArrayList codeOfString(String str) {

        //Base Case
        if (str.length() <= 0) {
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }


        char ch = str.charAt(0);
        String ros = str.substring(1);
        //Smaller Problem 1
        ArrayList<String> rr1 = codeOfString(ros);
        ArrayList<String> mr = new ArrayList<>();

        // Self Work 1
        char char_ch = (char) (ch + 48);

        for (String val : rr1) {
            mr.add(char_ch + val);
        }

        if (str.length() >= 2) {  //Need not to work for String smaller than 2
            //Smaller Problem 2
            String ch2 = str.substring(0, 2);
            String ros2 = str.substring(2);

            //The number must be smaller than 26 like 36 is not valid number
            if (Integer.parseInt(ch2) <= 26) {
                char char_ch2 = (char) (Integer.parseInt(ch2) + 'a' - 1);
                ArrayList<String> rr2 = codeOfString(ros2);
                // Self Work 2
                for (String val : rr2) {
                    mr.add(char_ch2 + val);
                }
            }
        }
        return mr;

    }
}
