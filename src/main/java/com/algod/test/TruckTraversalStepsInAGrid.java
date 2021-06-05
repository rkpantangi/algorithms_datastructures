package com.algod.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a square matrix of locations, where each cell indicates whether a given
 * location is reachable or not by road. 1 indicates reachable, 0 indicates
 * unreachable. There is one cell with value "9" and this cell is the
 * destination location.
 * 
 * So, starting from the first location (0, 0) - find the number of steps to
 * take to reach the destination. From any given cell, the truck can go
 * up/down/right/left. Going from one cell to another with any one of those four
 * options is considered 1 step.
 *
 */
public class TruckTraversalStepsInAGrid {

	public static void main(String[] args) {
		List<List<Integer>> area = new ArrayList<>();
		area.add(Arrays.asList(1, 0, 0));
		area.add(Arrays.asList(1, 0, 0));
		area.add(Arrays.asList(1, 9, 1));
		
		int dist = minimumDistance(3, 3, area);
		System.out.println(dist);
		
		area = new ArrayList<>();
		area.add(Arrays.asList(1, 0, 9));
		area.add(Arrays.asList(1, 1, 1));
		area.add(Arrays.asList(1, 1, 1));
		dist = minimumDistance(3, 3, area);
		System.out.println(dist);
	}

	private static int minimumDistance(int numRows, int numColumns, List<List<Integer>> area) {
		List<List<Integer>> tracker = new ArrayList<>(area.size());
		for (int i = 0; i < area.size(); i++) {
			List<Integer> areai = area.get(i);
			List<Integer> list = new ArrayList<>(areai.size());
			for (int j = 0; j < areai.size(); j++) {
				list.add(j, -2);
			}
			tracker.add(list);
		}

		int steps = recFind(area, 0, 0, numRows - 1, numColumns - 1, tracker);
		if (steps == Integer.MAX_VALUE)
			return -1;
		else
			return steps;
	}

	private static int recFind(List<List<Integer>> area, int r, int c, int numRows, int numColumns,
			List<List<Integer>> tracker) {
		if (r < 0 || r > numRows || c < 0 || c > numColumns)
			return Integer.MAX_VALUE;

		int trackerCost = tracker.get(r).get(c);
		if (trackerCost >= 0) {
			return trackerCost;
		} else if (trackerCost == -1) {
			return Integer.MAX_VALUE;
		}

		int cost;
		int elem = area.get(r).get(c);
		if (elem == 0) {
			cost = Integer.MAX_VALUE;
		} else if (elem == 9) {
			cost = 0;
		} else {
			tracker.get(r).set(c, -1);
			int lcost = recFind(area, r, c - 1, numRows, numColumns, tracker);
			int rcost = recFind(area, r, c + 1, numRows, numColumns, tracker);
			int ucost = recFind(area, r - 1, c, numRows, numColumns, tracker);
			int dcost = recFind(area, r + 1, c, numRows, numColumns, tracker);
	
			cost = Math.min(Math.min(Math.min(lcost, rcost), ucost), dcost);
			if (cost != Integer.MAX_VALUE) {
				cost++;
			}	
		}
		
		tracker.get(r).set(c, cost);
		return cost;
	}
}
