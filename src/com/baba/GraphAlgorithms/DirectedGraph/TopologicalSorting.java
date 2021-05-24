package com.baba.GraphAlgorithms.DirectedGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class TopologicalSorting {
    //https://www.geeksforgeeks.org/topological-sorting/
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.dfs();
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
        }

        private void dfsHelper(T src, Map<T, Boolean> visited, LinkedList<T> ordering) {
            //Recursive function to traverse the graph
            visited.put(src, true);
            for (T nbr : map.get(src)) {
                if (!visited.get(nbr)) {
                    dfsHelper(nbr, visited, ordering);
                }
            }
            ordering.addFirst(src);
        }

        private void dfs() {
            Map<T, Boolean> visited = new HashMap<>();
            LinkedList<T> ordering = new LinkedList<>();
            //first mark all nodes not visited
            for (var p : map.keySet()) {
                visited.put(p, false);
            }
            for (var p : map.keySet()) {
                if (!visited.get(p)) {
                    dfsHelper(p, visited, ordering);
                }
            }
            for (var a : ordering) {
                System.out.print(a + " ");
            }
        }
    }
}
