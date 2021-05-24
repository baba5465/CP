package com.baba.GreedyAlgorithm;

import java.util.Scanner;

public class LoadBalancer {
    /*
        SuperComputer Inc. have built a super-fast computer server consisting of N hyper-scalar
        lightning-fast processors Beta 007. These processors are numbered from 1 to N and are used
        to process independent jobs. Every new incoming job is assigned to an arbitrary processor.
        Sometimes, a processor may be assigned too many jobs while other processors have a relatively
        light load (or even wait idly). In that case, the whole system undergoes re-balancing.

        Re-balancing proceeds in rounds. In each round, every processor can transfer at most one job to
        each of its neighbors on the bus. Neighbors of the processor i are the processors i-1 and i+1
        (processors 1 and N have only one neighbor each, 2 and N-1 respectively). The goal of re-balancing
        is to achieve that all processors have the same number of jobs.

        Given the number of jobs initially assigned to each processor, you are asked to determine the minimal
        number of rounds needed to achieve the state when every processor has the same number of jobs, or to
        determine that such re-balancing is not possible.
    */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true) {
            int numberOfProcessor = s.nextInt();
            if (numberOfProcessor == -1) {
                break;
            }
            int[] arr = new int[numberOfProcessor];
            int max_load = Integer.MIN_VALUE;
            int load = 0;
            for (int i = 0; i < numberOfProcessor; i++) {
                arr[i] = s.nextInt();
                load += arr[i];
            }
            if (load % numberOfProcessor != 0) {
                System.out.println(-1);
                continue;
            }
            // Find load to be divided among the processes
            load = load / numberOfProcessor;
            int diff = 0;
            int ans;
            //we check difference of each block and calculate max_load to be transferred
            for (int i = 0; i < numberOfProcessor; i++) {
                diff += (arr[i] - load);
                ans = Math.abs(diff);
                max_load = Math.max(max_load,ans);
            }
            System.out.println(max_load);
        }
    }
}
