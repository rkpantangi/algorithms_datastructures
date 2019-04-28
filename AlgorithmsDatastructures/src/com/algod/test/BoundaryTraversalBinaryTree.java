package com.algod.test;

import com.algod.util.BTreePrinter;
import com.algod.util.TreeNode;

/**
 * Boundary traversal of a binary tree
 */
public class BoundaryTraversalBinaryTree {

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
		TreeNode<Integer> n10 = new TreeNode<>(10);
		TreeNode<Integer> n11 = new TreeNode<>(11);
		
		n1.left = n2;
		n1.right = n3;
		
		n3.left = n10;
		n3.right = n11;
		
		n2.left = n4;
		n2.right = n5;
		
		n5.left = n6;
		n6.left = n7;
		
		n6.right = n8;
		n8.right = n9;
		
		BTreePrinter.printNode(n1);
		
		printBinaryTreeBoundary(n1);
		
	}
	
	private static void printBinaryTreeBoundary(TreeNode<Integer> n1) {
		if (n1 == null) return;
		
		// print left boundary
		printLeftBounary(n1);
		// print leaves
		printLeaves(n1);
		// print right boundary
		printRightBoundary(n1);
	}
	
	private static void printLeftBounary(TreeNode<Integer> n) {
		if (n.left != null) {
			System.out.println(n.data);
			printLeftBounary(n.left);
		} else if (n.right != null) {
			System.out.println(n.data);
			printLeftBounary(n.right);
		}
	}

	private static void printLeaves(TreeNode<Integer> n) {
		if (n.left == null && n.right == null) {
			System.out.println(n.data);
		}
		if (n.left != null) {
			printLeaves(n.left);
		}
		if (n.right != null) {
			printLeaves(n.right);
		}
	}
	
	private static void printRightBoundary(TreeNode<Integer> n) {
		if (n.right != null) {
			printLeftBounary(n.right);
			System.out.println(n.data);
		} else if (n.left != null) {
			printLeftBounary(n.left);
			System.out.println(n.data);
		}
	}
}
