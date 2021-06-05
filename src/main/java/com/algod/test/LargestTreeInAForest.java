package com.algod.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find the largest tree (tree with the max number of nodes) in a forest, given the forest in a hashmap
 */
public class LargestTreeInAForest {

	public static void main(String[] args) {
		Map<Integer, Integer> forest = new HashMap<>() {{
			put(2, 3);
			put(5, 7);
			put(3, 4);
			put(6, 8);
			put(1, 4);
			put(4, 10);
		}};
		findTheLongestTreeInForest(forest);
	}

	private static void findTheLongestTreeInForest(Map<Integer, Integer> forest) {
		Set<Integer> visited = new HashSet<>(forest.size());
		Map<Integer, Integer> lengths = new HashMap<>(forest.size());
		for (Map.Entry<Integer, Integer> entry : forest.entrySet()) {
			if (!visited.contains(entry.getKey())) {
				int child = entry.getKey();
				visited.add(child);
				int length = 1;
				lengths.put(child, length);
				Integer parent = entry.getValue();

				while (parent != null) {
					if (visited.contains(parent)) {
						int clength = lengths.get(child);
						while(parent != null) {
							lengths.put(parent, lengths.get(parent) + clength);
							parent = forest.get(parent);
						}
						break;
					}
					lengths.put(parent,  lengths.get(child) + 1);
					visited.add(parent);
					child = parent;
					parent = forest.get(parent);
				}
			}
		}

		int maxlength = Integer.MIN_VALUE;
		int maxparent = 0;
		for (Map.Entry<Integer, Integer> entry : lengths.entrySet()) {
			if (maxlength < entry.getValue()) {
				maxlength = entry.getValue();
				maxparent = entry.getKey();
			}
		}
		System.out.println("Max root - " + maxparent + ", number of nodes - " + maxlength);
	}
}
