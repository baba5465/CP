package com.baba.GraphAlgorithms.UndirectedGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class CycleDetection {
    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1, true);
        g.addEdge(1, 2, true);
        g.addEdge(2, 3, true);
        g.addEdge(3, 4, true);
        g.addEdge(4, 0, true);

        if (g.containsCycle(0)) {
            System.out.println("Cycle is present");
        } else {
            System.out.println("No Cycle");
        }
    }

    static class Graph<T> {
        private final Map<T, LinkedList<T>> map = new HashMap<>();

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

        private boolean cycleHelper(T src, Map<T, Boolean> visited, T parent) {
            visited.put(src, true);
            for (var a : map.get(src)) {
                if (!visited.get(a)) {
                    if (cycleHelper(a, visited, src)) {
                        return true;
                    }
                } else if (a != parent) {
                    return true;
                }
            }
            return false;
        }

        private boolean containsCycle(T src) {
            Map<T, Boolean> visited = new HashMap<>();
            //first mark all nodes not visited
            for (var p : map.keySet()) {
                visited.put(p, false);
            }
            return cycleHelper(src, visited, null);
        }
    }
}
