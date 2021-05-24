package com.baba.CollectionsExample;

import java.util.*;

public class UseOfPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Car> pq = new PriorityQueue<>(Comparator.comparingInt(Car::dist));
        int[] x = {5, 6, 7, 3, 2, 1, 0};
        int[] y = {-2, 3, 9, 7, 2, 0, 1};
        for (int i = 0; i < x.length; i++) {
            pq.add(new Car(i, x[i], y[i]));
        }
        while (!pq.isEmpty()) {
            pq.poll().print();
        }

    }

    static class Car {
        int id;
        int x, y;

        private Car(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }


        private int dist() {
            return x * x + y * y;
        }

        private void print() {
            System.out.println("Id " + id);
            System.out.println("Location (" + x + ", " + y + ")");
        }
    }
}
