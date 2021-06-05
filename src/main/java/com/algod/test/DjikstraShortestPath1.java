package com.algod.test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DjikstraShortestPath1 {

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

	}
	
	private static void printPath(int target, int [] sdpath, int src) {
	}
}
