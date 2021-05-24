package com.baba.GraphAlgorithms.Traversal;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class BFS {

    public static void main(String[] args) {
        Graph<Integer> g = new Graph<>();
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(4, 5);

        g.bfs(0);
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

        private void bfs(T src) {
            Map<T, Boolean> visited = new HashMap<>();
            LinkedList<T> q = new LinkedList<>();
            q.add(src);
            visited.put(src, true);
            while (!q.isEmpty()) {
                src = q.poll();
                System.out.print(src + " ");
                for (T temp : map.get(src)) {
                    if (!visited.getOrDefault(temp, false)) {
                        q.push(temp);
                        visited.put(temp, true);
                    }
                }
            }
        }
    }
}
