package com.algod.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MaximumValueFromEachLeaf {

	private static  class InvertedTreeNode {
		int data;
		int max;
		InvertedTreeNode parent;
		
		public InvertedTreeNode(int data) {
			super();
			this.data = data;
			this.max = data;
		}
		
		public void printTree() {
			System.out.println(" data - " + data + ", max - " + max);
			if (parent != null) parent.printTree();
		}
	}
	
	// map of all nodes to their corresponding tree nodes for quick insertion
	private static Map<Integer, InvertedTreeNode> map = new HashMap<>();
	
	private static Map<Integer, Integer> maxv = new HashMap<>();
	
	public static void main(String[] args) {
		// tree example is -
		//					4
		//			1				5
		//		9				3		6
		//	8		2
		int [] arr = new int [] {6, 4, 1, 4, 5, 1, 9, 5, 3, 5, 6, 9, 8, 9, 2};
		Map<Integer, InvertedTreeNode> leaves = new HashMap<>();
		for (int i=1;i<arr.length;i+=2) {
			int from = arr[i];
			int to = arr[i+1];
			
			InvertedTreeNode parent = map.get(from);
			
			if (parent == null) {
				parent = leaves.get(from);
				// was it a child
				if (parent == null) {
					// first time seen
					parent = new InvertedTreeNode(from);
				} else {
					leaves.remove(from);
				}
				map.put(from, parent);
			}
			
			InvertedTreeNode child = leaves.get(to);
			if (child != null ) {
				throw new IllegalArgumentException("Leaf " + to + " seen more than once!");
			}
			
			// is it seen as a parent
			child = map.get(to);
			if (child == null) {
				child = new InvertedTreeNode(to);
				leaves.put(to, child);
			} else {
				map.put(to, child);
			}
			child.parent = parent;
		}

		for (Entry<Integer, InvertedTreeNode> entry : leaves.entrySet()) {
			System.out.println("Printing for leaf - " + entry.getKey());
			entry.getValue().printTree();
		}
		
		for (Entry<Integer, InvertedTreeNode> entry : leaves.entrySet()) {
			int max = findMaxOfLeaf(entry.getValue(), entry.getValue().data);
			maxv.put(entry.getKey(), max);
		}

		for (Entry<Integer, InvertedTreeNode> entry : leaves.entrySet()) {
			System.out.println("Printing for leaf - " + entry.getKey());
			entry.getValue().printTree();
		}
		
		System.out.println(maxv);
	}
	
	private static int findMaxOfLeaf(InvertedTreeNode value, int max) {
		if (value == null) {
			return Integer.MIN_VALUE;
		}
		value.max = Math.max(value.data, max);
		int retmax = findMaxOfLeaf(value.parent, value.max);
		return Math.max(retmax, value.max);
	}
}
