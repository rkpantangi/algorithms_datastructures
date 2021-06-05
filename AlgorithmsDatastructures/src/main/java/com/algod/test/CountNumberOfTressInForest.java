package com.algod.test;

import com.algod.util.Graph;

import java.util.LinkedList;

public class CountNumberOfTressInForest {


    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(3, 4);
        System.out.println(countTreesInForest(g));
    }

    private static int countTreesInForest(Graph g) {
        int res = 0;
        boolean[] visited = new boolean[g.getNumOfVertices()];
        for (int i=0;i<g.getNumOfVertices();i++) {
            if (!visited[i]) {
                traverse(g, i, visited);
                res++;
            }
        }
        return res;
    }

    private static void traverse(Graph g, int node, boolean [] visited) {
        LinkedList<Integer> edges = g.getEdges(node);
        visited[node] = true;
        for (int e : edges) {
            if (!visited[e]) {
                traverse(g, e, visited);
            }
        }
    }
}
