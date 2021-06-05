package com.algod.util;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private int numOfVertices;
    private List<LinkedList<Integer>> edges;

    public Graph(int n) {
        this.numOfVertices = n;
        edges = new ArrayList<>(n);
        for (int i =0;i<n;i++) {
            edges.add(new LinkedList<>());
        }
    }

    public int getNumOfVertices() {
        return numOfVertices;
    }

    public List<LinkedList<Integer>> getEdges() {
        return edges;
    }

    public LinkedList<Integer> getEdges(int node) {
        return edges.get(node);
    }

    public void addEdge(int f, int t) {
        edges.get(f).add(t);
    }
}
