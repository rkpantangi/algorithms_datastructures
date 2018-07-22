package com.algod.test;

import java.util.Arrays;

public class BellmanFordShortestPath {

	public static void main(String[] args) {
		int [][] adjMatrix = new int[][] {
			{Integer.MAX_VALUE, -1, 4, Integer.MAX_VALUE, Integer.MAX_VALUE},
			{Integer.MAX_VALUE, Integer.MAX_VALUE, 3, 2, 2},
			{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
			{Integer.MAX_VALUE, 1, 5, Integer.MAX_VALUE, Integer.MAX_VALUE},
			{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -3, Integer.MAX_VALUE}
		};

		findShortestPath(adjMatrix, 0);
		
		adjMatrix = new int[][] {
			{Integer.MAX_VALUE, 1, Integer.MAX_VALUE, 2},
			{Integer.MAX_VALUE, Integer.MAX_VALUE, 2, Integer.MAX_VALUE},
			{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
			{Integer.MAX_VALUE, -2, 1, Integer.MAX_VALUE},
		};

		findShortestPath(adjMatrix, 0);
	}
	
	private static void findShortestPath(int[][] adjMatrix, int src) {		
		int [] sd = new int [adjMatrix.length];
		int [] sdpath = new int [adjMatrix.length];
		
		Arrays.fill(sd, Integer.MAX_VALUE);
		sd[src] = 0;
		
		for (int vind=1;vind<adjMatrix.length;vind++) {
			boolean changed = false;
			for (int i=0;i<adjMatrix.length;i++) {
				for (int j=0;j<adjMatrix.length;j++) {
					if (adjMatrix[i][j] != Integer.MAX_VALUE) {
						int newdist = sd[i] + adjMatrix[i][j];
						if (newdist < sd[j]) {
							sd[j] = newdist;
							changed = true;
							sdpath[j] = i;
						}
					}
				}
			}
			if (!changed) break;
		}
		
		System.out.println("short distances - " + Arrays.toString(sd));
		System.out.println("short distances path - " + Arrays.toString(sdpath));
		
		for (int i=1;i<adjMatrix.length;i++) {
			System.out.print("Path for - " + i + ": ");
			printPath(i, sdpath, 0);
			System.out.println("");
		}
	}
	
	private static void printPath(int vertex, int [] sdpath, int src) {
		if (vertex != src) {
			printPath(sdpath[vertex], sdpath, src);
		}
		System.out.print(vertex + " ");
	}
}
