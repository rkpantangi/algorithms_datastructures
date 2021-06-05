package com.algod.test;

import java.util.ArrayList;

import com.algod.util.LinkedNode;
import com.algod.util.TreeNode;

/**
 * Generate a linked list of nodes from a Tree at each level.
 */
public class EachDepthLinkedListFromTree {

	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<>(1);
		TreeNode<Integer> n2 = n1.left(new TreeNode<>(2));
		TreeNode<Integer> n3 = n1.right(new TreeNode<>(3));

		n2.left(new TreeNode<>(4));
		n2.right(new TreeNode<>(5));
		
		n3.left(new TreeNode<>(6));
		n3.right(new TreeNode<>(7));

		ArrayList<LinkedNode<Integer>> heads = new ArrayList<>();
		createLinkedLists(n1, new ArrayList<LinkedNode<Integer>>(), heads, 0);
		
		heads.forEach(x -> System.out.println(x));
	}
	
	private static void createLinkedLists(TreeNode<Integer> n, ArrayList<LinkedNode<Integer>> tails, ArrayList<LinkedNode<Integer>> heads, int depth) {
		if (n == null) return;
		LinkedNode<Integer> newn = new LinkedNode<>(n.data);
		if (tails.size() == depth) {
			tails.add(depth, newn);
			heads.add(depth, newn);
		} else {
			LinkedNode<Integer> existing = tails.set(depth, newn);
			existing.next(newn);
		}
		createLinkedLists(n.left, tails, heads, depth+1);
		createLinkedLists(n.right, tails, heads, depth+1);
	}

}