package com.algod.test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DjikstraShortestPath {

	public static void main(String[] args) {
		int [][] adjMatrix = new int[][] {
			{0, 4, 0, 0, 0, 0, 0, 8, 0},
            {4, 0, 8, 0, 0, 0, 0, 11, 0},
            {0, 8, 0, 7, 0, 4, 0, 0, 2},
            {0, 0, 7, 0, 9, 14, 0, 0, 0},
            {0, 0, 0, 9, 0, 10, 0, 0, 0},
            {0, 0, 4, 14, 10, 0, 2, 0, 0},
            {0, 0, 0, 0, 0, 2, 0, 1, 6},
            {8, 11, 0, 0, 0, 0, 1, 0, 7},
            {0, 0, 2, 0, 0, 0, 6, 7, 0}
		};
		
		findShortestPath(adjMatrix, 0);
	}

	private static class Data implements Comparable<Data> {
		int vertex;
		int distance;
		
		public Data(int vertex, int distance) {
			super();
			this.vertex = vertex;
			this.distance = distance;
		}

		@Override
		public int compareTo(Data o) {
			return Integer.compare(this.distance, o.distance);
		}
	}
	
	private static void findShortestPath(int[][] adjMatrix, int src) {
		PriorityQueue<Data> pq = new PriorityQueue<Data>();
		
		int [] sd = new int [adjMatrix.length];
		int [] parent = new int [adjMatrix.length];
		int [] explored = new int [adjMatrix.length];
		
		Arrays.fill(sd, Integer.MAX_VALUE);
		sd[src] = 0;
		
		pq.add(new Data(src, 0));
		while(pq.size() > 0) {
			Data exploringVertexInd = pq.poll();
			int exploringVertex = exploringVertexInd.vertex;
			for (int i=0;i<adjMatrix.length;i++) {
				if (explored[i] == 0) {
					int w = adjMatrix[exploringVertex][i];
					if (w > 0) {
						int newdist = sd[exploringVertex] + w;
						if (newdist < sd[i]) {
							sd[i] = newdist;
							parent[i] = exploringVertex;
						}
						pq.add(new Data(i, sd[i]));
					}
				}
			}
			explored[exploringVertex] = 1;
		}
		
		System.out.println("short distances - " + Arrays.toString(sd));
		System.out.println("short distances path - " + Arrays.toString(parent));
		
		for (int i=1;i<adjMatrix.length;i++) {
			System.out.print("Path for - " + i + ": ");
			printPath(i, parent, 0);
			System.out.println("");
		}
	}
	
	private static void printPath(int target, int [] sdpath, int src) {
		if (target != src) {
			printPath(sdpath[target], sdpath, src);
		}
		System.out.print(target + " ");
	}
}
