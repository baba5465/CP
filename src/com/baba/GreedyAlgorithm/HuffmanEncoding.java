package com.baba.GreedyAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;

public class HuffmanEncoding {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] freq = {5, 9, 12, 13, 16, 45};
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getFreq));
        for (int i = 0; i < freq.length; i++) {
            Node temp = new Node();
            temp.setaChar(chars[i]);
            temp.setFreq(freq[i]);
            temp.setLeft(null);
            temp.setRight(null);
            pq.add(temp);
        }
        Node root = null;
        while (pq.size() > 1) {
            Node a = pq.poll();
            Node b = pq.poll();
            Node f = new Node();
            assert b != null;
            f.setFreq(a.getFreq() + b.getFreq());
            f.setaChar('-');
            f.setLeft(a);
            f.setRight(b);
            root = f;
            pq.add(f);
        }
        assert root != null;
        printCode(root, "");
    }

    public static void printCode(Node root, String s) {
        if (root.getLeft() == null
                && root.getRight() == null
                && Character.isLetter(root.getaChar())) {

            System.out.println(root.getaChar() + ":" + s);
            return;
        }
        printCode(root.getLeft(), s + "0");
        printCode(root.getRight(), s + "1");
    }
}

class Node {
    private int freq;
    private char aChar;
    private Node left;
    private Node right;

    public Node() {
    }

    public int getFreq() {
        return freq;
    }

    public void setFreq(int freq) {
        this.freq = freq;
    }

    public char getaChar() {
        return aChar;
    }

    public void setaChar(char aChar) {
        this.aChar = aChar;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
