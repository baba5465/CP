package com.baba.GraphAlgorithms.Traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HolidayAccomodation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for (int j = 1; j <= t; j++) {
            int n = s.nextInt();
            int src = 0;
            Graph g = new Graph(n);
            for (int i = 1; i < n; i++) {
                int u = s.nextInt();
                src = u;
                int v = s.nextInt();
                int z = s.nextInt();
                g.addEdge(u, v, z);
            }
            System.out.println("Case #" + j + ":" + g.dfs(src));
        }
    }

    private static class Graph {
        private final int vertices;
        private final Map<Integer, ArrayList<Edge>> l;
        private int ans;

        public Graph(int vertices) {
            this.vertices = vertices;
            ans = 0;
            l = new HashMap<>();
        }

        private void addEdge(int u, int v, int z) {
            Edge e = new Edge(v, z);
            Edge e1 = new Edge(u, z);
            if (!l.containsKey(u)) {
                l.put(u, new ArrayList<>());
            }
            if (!l.containsKey(v)) {
                l.put(v, new ArrayList<>());
            }
            l.get(u).add(e);
            l.get(v).add(e1);
        }

        private int dfsHelper(int node, Map<Integer, Boolean> visited, Map<Integer, Integer> count) {
            visited.put(node, true);
            count.put(node, 1);

            for (var a : l.get(node)) {
                if (!visited.get(a.dest)) {
                    count.put(node, count.get(node) + dfsHelper(a.dest, visited, count));
                    int nx = count.get(a.dest);
                    int ny = vertices - nx;

                    this.ans += 2 * Math.min(nx, ny) * a.weight;
                }
            }
            return count.get(node);
        }

        private int dfs(int src) {
            Map<Integer, Boolean> visited = new HashMap<>();
            Map<Integer, Integer> count = new HashMap<>();
            for (var a : l.keySet()) {
                visited.put(a, false);
                count.put(a, 0);
            }
            dfsHelper(src, visited, count);
            return ans;
        }
    }

    private static class Edge {
        private final int dest;
        private final int weight;

        public Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }
}
