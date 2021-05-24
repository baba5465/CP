package com.baba.GraphAlgorithms.Traversal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ConnectedComponents {

    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(0, 3);
        g.addEdge(0, 4);

        g.addEdge(5, 6);
        g.addEdge(6, 7);
        g.addEdge(8, 8);


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

        private void dfs() {
            Map<T, Boolean> visited = new HashMap<>();
            //first mark all nodes not visited
            for (var p : map.keySet()) {
                visited.put(p, false);
            }
            int component = 0;
            for (var p : map.keySet()) {

                if (!visited.get(p)) {
                    System.out.println("Component " + component);
                    dfsHelper(p, visited);
                    System.out.println();
                    component++;
                }
            }
        }
    }
}

