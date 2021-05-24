package com.baba.GraphAlgorithms.UndirectedGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Bipartite {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
//        g.addEdge(1,2,true);
//        g.addEdge(2,3,true);
//        g.addEdge(3,1,true);
//        g.addEdge(3,4,true);
//        g.addEdge(4,5,true);
        g.addEdge(1, 2, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);
        g.addEdge(4, 1, true);
        g.containsCycle();
    }

    static class Graph<T> {
        private final Map<T, LinkedList<T>> map = new HashMap<>();
        private boolean odd_cycle = false;

        private void addEdge(T src, T des, boolean bidirectional) {
            if (!map.containsKey(src)) {
                map.put(src, new LinkedList<>());
            }
            if (!map.containsKey(des)) {
                map.put(des, new LinkedList<>());
            }
            map.get(src).add(des);
            if (bidirectional) {
                map.get(des).add(src);
            }
        }

        private void dfs(T current, Map<T, Integer> visited, T parent, int color) {
            visited.put(current, color);
            for (var child : map.get(current)) {
                if (visited.get(child) == 0) {
                    dfs(child, visited, current, 3 - color);
                } else if (child != parent && visited.get(child) == color) {
                    // Back edge and odd length cycle
                    odd_cycle = true;
                }
            }
        }

        private void containsCycle() {
            Map<T, Integer> visited = new HashMap<>();
            //first mark all nodes not visited
            T current = map.keySet().iterator().next();
            for (var p : map.keySet()) {
                visited.put(p, 0);
            }
            dfs(current, visited, null, 1);
            if (odd_cycle) {
                System.out.println("Not Bipartite");
            } else {
                System.out.println("Bipartite");
            }
        }
    }
}
