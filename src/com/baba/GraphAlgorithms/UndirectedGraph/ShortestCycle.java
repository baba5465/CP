package com.baba.GraphAlgorithms.UndirectedGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ShortestCycle {

    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 4);
        g.addEdge(2, 5);
        g.addEdge(4, 5);
        g.addEdge(5, 3);
        g.solve();
    }

    static class Graph<T> {
        private final Map<T, LinkedList<T>> map = new HashMap<>();
        private int ans;

        private void addEdge(T src, T des) {
            if (!map.containsKey(src)) {
                map.put(src, new LinkedList<>());
            }
            if (!map.containsKey(des)) {
                map.put(des, new LinkedList<>());
            }
            map.get(src).add(des);
            map.get(des).add(src);
        }

        private void bfs(T src) {
            Map<T, Integer> distance = new HashMap<>();
            Queue<T> q = new LinkedList<>();

            for (var child : map.keySet()) {
                distance.put(child, Integer.MAX_VALUE);
            }
            q.add(src);
            distance.put(src, 0);
            while (!q.isEmpty()) {
                T curr = q.poll();
                for (var neigh : map.get(curr)) {
                    if (distance.get(neigh) == Integer.MAX_VALUE) {
                        distance.put(neigh, distance.get(curr) + 1);
                        q.add(neigh);
                    } else if (distance.get(neigh) >= distance.get(curr)) {
                        ans = Math.min(ans, distance.get(neigh) + distance.get(curr) + 1);

                    }
                }
            }
        }

        private void solve() {
            ans = map.size() + 1;
            for (var a : map.keySet()) {
                bfs(a);
            }
            if (ans == map.size() + 1) {
                System.out.println("No cycle");
            } else {
                System.out.println("Length of shortest cycle is " + ans);
            }
        }

    }
}
