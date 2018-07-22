package com.algod.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KruskalMinimumSpanningTree {

	private static class Graph {
		int v;
		int e;
		Edge [] edges;
		
		public Graph(int v, int e) {
			super();
			this.v = v;
			this.e = e;
			this.edges = new Edge[e];
			Arrays.setAll(edges, i -> new Edge());
		}
		
		private List<Edge> constructMST() {
			List<Edge> res = new ArrayList<>();
			res.replaceAll(i -> new Edge());
			
			Arrays.sort(edges);
			
			SubSet [] subsets = new SubSet[v];
			Arrays.setAll(subsets, i -> new SubSet(i));
			
			for (int i=0;i<e&&res.size()<v-1;i++) {
				Edge e = edges[i];
				int root1 = findSet(subsets, e.src);
				int root2 = findSet(subsets, e.dest);
				
				if (root1 != root2) {
					union(subsets, root1 , root2);
					res.add(e);
				}
			}
			return res;
		}

		private void union(SubSet [] subsets, int root1, int root2) {
			if (subsets[root1].rank >= subsets[root2].rank) {
				if (subsets[root1].rank == subsets[root2].rank) {
					subsets[root1].rank++;
				}
				subsets[root2].parent = subsets[root1];
			} else {
				subsets[root1].parent = subsets[root2];
				subsets[root2].rank++;
			}
		}

		private int findSet(SubSet[] subsets, int from) {
			int parent = subsets[from].parent.val;
			if (subsets[parent].val != subsets[parent].parent.val) {
				parent = findSet(subsets, parent);
			}
			return parent;
		}
		
	}
	
	private static class Edge implements Comparable<Edge> {
		int src;
		int dest;
		int weight;
		
		public Edge() {
			super();
		}

		public Edge(int from, int to, int weight) {
			super();
			this.src = from;
			this.dest = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	private static class SubSet {
		int val;
		SubSet parent;
		int rank;
		public SubSet(int val) {
			super();
			this.val = val;
			this.parent = this;
			this.rank = 0;
		}
		@Override
		public String toString() {
			return "SubSet [val=" + val + ", parent=" + parent.val + ", rank=" + rank + "]";
		}
		
	}
	
	public static void main(String[] args) {
		Graph graph = new Graph(4, 5);
        graph.edges[0] = new Edge(0, 1, 10);
        graph.edges[1] = new Edge(0, 2, 6);
        graph.edges[2] = new Edge(0, 3, 5);
        graph.edges[3] = new Edge(1, 3, 15);
        graph.edges[4] = new Edge(2, 3, 4);
        
		List<Edge> mst = graph.constructMST();
		
		System.out.println("1st example.....");
		mst.forEach(x -> {
			System.out.println(x.src + " - " + x.dest);
		});
		
		graph = new Graph(6, 9);
        graph.edges[0] = new Edge(0, 1, 3);
        graph.edges[1] = new Edge(0, 3, 1);
        graph.edges[2] = new Edge(1, 2, 1);
        graph.edges[3] = new Edge(1, 3, 3);
        graph.edges[4] = new Edge(2, 3, 1);
        graph.edges[5] = new Edge(2, 4, 5);
        graph.edges[6] = new Edge(2, 5, 4);
        graph.edges[7] = new Edge(3, 4, 6);
        graph.edges[8] = new Edge(4, 5, 2);
        
		mst = graph.constructMST();
		
		System.out.println("2nd example.....");
		mst.forEach(x -> {
			System.out.println(x.src + " - " + x.dest);
		});
	}
	
}
