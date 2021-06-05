package com.algod.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Find the largest tree (tree with the max number of nodes) in a forest, given the forest in a hashmap
 */
public class LargestTreeInAForest1 {

	static class  UnionFind {
		public int[] parents;

		public int seeFavParent() {
			HashMap<Integer, Integer> map = new HashMap<>();

			int max = Integer.MIN_VALUE;
			for (int i = 1; i < parents.length; i++) {
				int par = this.find(i);
				map.put(par, map.getOrDefault(par, 0) + 1);
				max = Math.max(max, map.get(par));
			}
			return max;
		}

		public UnionFind(int n ) {
			this.parents = new int[n + 1];
			for (int i = 1; i < n + 1; i++) {
				parents[i] = i;
			}
		}


		public int find(int x) {
			if (parents[x] == x) {
				return x;
			} else {
				return parents[x] = find(parents[x]);
			}
		}

		public void connect(int x, int y) {
			int root_x = find(x);
			int root_y = find(y);

			if (root_x != root_y) {
				parents[root_x] = root_y;
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(trees(new int[][]{{2,3}, {5,7}, {3,4},{6,8}, {1,4}, {4, 10}}));
	}

	public static int trees(int[][] input) {
		UnionFind unionFind = new UnionFind(10);

		for (int[] tree: input) {
			unionFind.connect(tree[0], tree[1]);
		}
		return unionFind.seeFavParent();
		// return 1;
	}
}
