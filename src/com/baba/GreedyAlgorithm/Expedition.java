package com.baba.GreedyAlgorithm;

import java.util.*;

public class Expedition {
    /*
    {@link} : https://www.spoj.com/problems/EXPEDI/
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            ArrayList<Pair> arr = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            int prev_stop = 0;
            int curr_stop = 0;
            int ans = 0;
            int flag = 0;
            int n = s.nextInt();
            for (int i = 0; i < n; i++) {
                int dis = s.nextInt();
                int fuel = s.nextInt();
                arr.add(new Pair(dis, fuel));
            }

            int finDis = s.nextInt();
            int curr_Fuel = s.nextInt();

            arr.sort(Collections.reverseOrder(Comparator.comparingInt(Pair::getDistance)));

            for (Pair pair : arr) {
                pair.setDistance(finDis - pair.getDistance());
            }

            while (curr_stop < n) {
                if (curr_Fuel >= (arr.get(curr_stop).getDistance() - prev_stop)) {
                    curr_Fuel -= (arr.get(curr_stop).getDistance() - prev_stop);
                    pq.add(arr.get(curr_stop).getFuel());
                    prev_stop = arr.get(curr_stop).getDistance();
                } else {
                    if (pq.isEmpty()) {
                        flag = 1;
                        break;
                    }
                    curr_Fuel += pq.poll();
                    ans++;
                    continue;
                }
                curr_stop++;
            }
            if (flag == 1) {
                System.out.println(-1);
                continue;
            }
            finDis -= arr.get(arr.size()- 1).getDistance();
            if (curr_Fuel >= finDis) {
                System.out.println(ans);
                continue;
            }
            while (curr_Fuel < finDis) {
                if (pq.isEmpty()) {
                    flag = 1;
                    break;
                }
                curr_Fuel += pq.poll();
                ans++;
            }
            if (flag == 1) {
                System.out.println(-1);
                continue;
            }
            System.out.println(ans);
        }
    }

    static class Pair {
        private int distance;
        private int fuel;

        public Pair(int distance, int fuel) {
            this.distance = distance;
            this.fuel = fuel;
        }

        public int getDistance() {
            return distance;
        }

        public int getFuel() {
            return fuel;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }
    }
}
