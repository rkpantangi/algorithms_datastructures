package com.algod.test;

import com.algod.util.BTreePrinter2;
import com.algod.util.TreeNode;

/**
 * Check if the brinary tree is balanced or not.
 */
public class CheckBinaryTreeBalanced {

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
		
		n3.left = n6;
		n3.right = n7;
		
		n4.left = n8;
		n8.left = n9;
		
		BTreePrinter2.printNode(n1);		
		System.out.println("Is balanced Binary tree? -  " + isBalanced(n1));
		
		n8.left = null;
		n4.right = n9;
		BTreePrinter2.printNode(n1);		
		System.out.println("Is balanced Binary tree? -  " + isBalanced(n1));
		
		n4.left = null;
		n4.right = null;
		n6.left = n8;
		n7.right = n9;
		BTreePrinter2.printNode(n1);		
		System.out.println("Is balanced Binary tree? -  " + isBalanced(n1));
	}
	
	private static boolean isBalanced(TreeNode<Integer> node) {
		return checkHeightDiff(node) != Integer.MIN_VALUE;
	}

	private static int checkHeightDiff(TreeNode<Integer> node) {
		if (node == null) return -1;
		int lefth = checkHeightDiff(node.left);
		if (lefth == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		int righth = checkHeightDiff(node.right);
		if (righth == Integer.MIN_VALUE) return Integer.MIN_VALUE;
		
		if (Math.abs(lefth - righth) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Math.max(lefth, righth) + 1;
		}
		
	}
}
