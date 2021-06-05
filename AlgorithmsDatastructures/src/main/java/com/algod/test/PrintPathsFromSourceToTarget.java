package com.algod.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1, and return them in any order.
 */
public class PrintPathsFromSourceToTarget {

	public static void main(String[] args) {
		int [][] graph = new int[][] {
				{1, 2},
				{3},
				{3},
				{}
		};
		List<List<Integer>> paths = getAllPaths(graph);
		System.out.println(paths);

		graph = new int[][]{
				{4, 3, 1},
				{3, 2, 4},
				{3},
				{4},
				{}
		};
		paths = getAllPaths(graph);
		System.out.println(paths);

		graph = new int[][]{
				{1, 2, 3},
				{2},
				{3},
				{}
		};
		paths = getAllPaths(graph);
		System.out.println(paths);
	}

	private static List<List<Integer>> getAllPaths(int[][] graph) {
		List<List<Integer>> paths = new ArrayList<>();
		int target = graph.length-1;
		Queue<List<Integer>> toProcess = new LinkedList<>();
		List<Integer> initialPath = new ArrayList<>();
		initialPath.add(0);
		toProcess.add(initialPath);

		while(!toProcess.isEmpty()) {
			List<Integer> processPath = toProcess.poll();

			int [] neighbours = graph[processPath.get(processPath.size()-1)];
			for (int neighbour : neighbours) {
				List<Integer> newPath = new ArrayList<>(processPath);
				newPath.add(neighbour);
				if (neighbour == target) {
					paths.add(newPath);
				} else {
					toProcess.add(newPath);
				}
			}
		}
		return paths;
	}
}
