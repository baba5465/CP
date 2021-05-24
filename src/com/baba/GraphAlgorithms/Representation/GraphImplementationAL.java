package com.baba.GraphAlgorithms.Representation;

import java.util.LinkedList;

public class GraphImplementationAL {
    /*
    Implementation of graph using adjacency list
     */
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(1, 2);
        g.print();
    }

    private static class Graph {
        private final int vertex;
        private final LinkedList[] l;

        public Graph(int vertex) {
            this.vertex = vertex;
            l = new LinkedList[vertex];
            for (int i = 0; i < vertex; i++) l[i] = new LinkedList();
        }

        public void addEdge(int x, int y) {
            l[x].add(y);
            l[y].add(x);
        }

        public void print() {
            for (int i = 0; i < vertex-1; i++) {
                System.out.print("Vertex " + i + "->");
                for (Object a : l[i]) {
                    System.out.print(a + " ");
                }
                System.out.println();
            }
        }
    }
}
