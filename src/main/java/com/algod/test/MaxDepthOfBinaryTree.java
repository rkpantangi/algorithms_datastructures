package com.algod.test;

import com.algod.util.BTreePrinter2;
import com.algod.util.TreeNode;

public class MaxDepthOfBinaryTree {

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
		printTree(n1);
		
		BTreePrinter2.printNode(n1);
		
		System.out.println("Height from bottom2: " + heightFromBottom(n1));
	}
	
	private static void printTree(TreeNode<Integer> n) {
		if (n == null) return;
		System.out.println(n.data);
		
		if (n.left != null) printTree(n.left);
		if (n.right != null) printTree(n.right);
	}

	private static int heightFromBottom(TreeNode<Integer> n) {
		if (n == null) return -1;
		int lheight = heightFromBottom(n.left);
		int rheight = heightFromBottom(n.right);
		return Math.max(lheight, rheight) + 1;
	}

}
