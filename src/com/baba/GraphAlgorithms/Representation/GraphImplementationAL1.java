package com.baba.GraphAlgorithms.Representation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphImplementationAL1 {
    /*
    Generic graph representation

    https://algorithms.tutorialhorizon.com/weighted-graph-implementation-java/
    https://www.geeksforgeeks.org/implementing-generic-graph-in-java/

     */

    public static void main(String[] args) {
        Graph<String> g = new Graph<>();
        g.addEdge("A","B",20,true);
        g.addEdge("B","D",40,true);
        g.addEdge("A","C",10,true);
        g.addEdge("C","D",40,true);
        g.addEdge("A","D",50,false);
        g.print();
    }

    private static class Graph<T> {
        private int vertices;
        private final Map<T, LinkedList<Edge<T>>> map = new HashMap<>();

        private void addVertex(T s) {
            map.put(s, new LinkedList<>());
        }

        private void addEdge(T source, T dest, int weight, boolean bidirectional) {
            if (!map.containsKey(source))
                addVertex(source);

            if (!map.containsKey(dest))
                addVertex(dest);

            map.get(source).add(new Edge<>(dest, weight));
            if (bidirectional) {
                map.get(dest).add(new Edge<>(source, weight));
            }
        }

        private void print() {
            for (var a : map.keySet()) {
                System.out.print("Vertex "+a+" -> ");
                for (var i: map.get(a)){
                    System.out.print("Destination "+i.destination+" Weight "+i.weight+", ");
                }
                System.out.println();
            }
        }
    }

    private static class Edge<T> {
        private final T destination;
        private final int weight;

        public Edge(T destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }
}
