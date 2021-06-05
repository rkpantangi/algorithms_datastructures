package com.algod.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import com.algod.util.BTreePrinter2;
import com.algod.util.TreeNode;

public class MaxWidthOfBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<>(1);
		TreeNode<Integer> n2 = new TreeNode<>(2);
		TreeNode<Integer> n3 = new TreeNode<>(3);
		TreeNode<Integer> n4 = new TreeNode<>(4);
		TreeNode<Integer> n5 = new TreeNode<>(5);
		TreeNode<Integer> n6 = new TreeNode<>(6);
		TreeNode<Integer> n7 = new TreeNode<>(7);
		TreeNode<Integer> n8 = new TreeNode<>(8);
		TreeNode<Integer> n9 = new TreeNode<>(9);
		
		n1.left = n2;
		n1.right = n3;
		
		n2.left = n4;
		n2.right = n5;
		
		n5.left = n6;
		n6.left = n7;
		
		n6.right = n8;
		n8.right = n9;
		
		BTreePrinter2.printNode(n1);
		
		System.out.println("Max width of tree: " + approach1(n1));
		
		System.out.println("Max width of tree: " + approach2(n1));
	}

	/**
	 * using Depth first traversal approach
	 */
	private static int approach1(TreeNode<Integer> n) {
		ArrayList<Integer> widths = new ArrayList<>();		
		traverseTree(n, 1, widths);
		return Collections.max(widths);
	}

	private static void traverseTree(TreeNode<Integer> n, int height, ArrayList<Integer> widths) {
		if (n == null) return;
		
		if (widths.size() < height) {
			widths.add(0);
		}
		widths.set(height-1, widths.get(height-1)+1);
		
		if (n.left != null) {
			traverseTree(n.left, height+1, widths);
		}
		
		if (n.right != null) {
			traverseTree(n.right, height+1, widths);
		}
	}

	/**
	 * Using Bread first traversal approach
	 */
	private static int approach2(TreeNode<Integer> n) {
		LinkedList<TreeNode<Integer>> nodes = new LinkedList<>();
		
		nodes.add(n);
		int count = 0;
		
		while(!nodes.isEmpty()) {
			int num = nodes.size();
			count = Math.max(count, num);
			
			for(int i=1;i<=num;i++) {
				TreeNode<Integer> node = nodes.remove();
				if (node.left != null) {
					nodes.add(node.left);
				}
				
				if (node.right != null) {
					nodes.add(node.right);
				}				
			}
		}
		return count;
	}

}
