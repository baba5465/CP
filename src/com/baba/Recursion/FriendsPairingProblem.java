package com.baba.Recursion;

import java.util.Scanner;

public class FriendsPairingProblem {
    /*
    Given n friends, each one can remain single or can be paired up
    with some other friend. Each friend can be paired only once.
    Find out the total number of ways in which friends can remain
    single or can be paired up.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            long n = s.nextLong();
            System.out.println(pairing(n));
        }
    }
    private static long pairing(long n){
        if(n==1 || n==0){
            return 1;
        }
        return pairing(n-1) + pairing(n-2)*(n-1);
    }
}
