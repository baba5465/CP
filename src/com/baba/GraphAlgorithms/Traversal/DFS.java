package com.baba.GraphAlgorithms.Traversal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class DFS {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 8);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(4, 6);

        g.dfs(0);
    }

    static class Graph<T> {
        private final Map<T, LinkedList<T>> map = new HashMap<>();

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

        private void dfsHelper(T src, Map<T, Boolean> visited) {
            //Recursive function to traverse the graph
            System.out.print(src + " ");
            visited.put(src, true);
            for (T nbr : map.get(src)) {
                if (!visited.get(nbr)) {
                    dfsHelper(nbr, visited);
                }
            }
        }

        private void dfs(T src) {
            Map<T, Boolean> visited = new HashMap<>();
            //first mark all nodes not visited
            for (var p : map.keySet()) {
                visited.put(p, false);
            }

            dfsHelper(src, visited);
        }
    }
}
