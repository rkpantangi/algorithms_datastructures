package com.algod.test;

import com.algod.util.BTreePrinter;
import com.algod.util.TreeNode;

public class DiameterOfBinaryTree1 {

	public static void main(String[] args) {
		run1();
		run2();
	}

	private static void run1() {
		TreeNode<Integer> n1 = new TreeNode<>(1);
		n1.right(3);
		TreeNode<Integer> n2 = n1.left(2);

		TreeNode<Integer> n4 = n2.left(4);

		TreeNode<Integer> n5 = n2.right(5);

		TreeNode<Integer> n8 = n4.left(8);
		n8.left(10);

		TreeNode<Integer> n9 = n5.left(9);
		n9.left(11);

		BTreePrinter.printNode(n1);
		int d = diameter(n1);
		System.out.println("Run1: diameter - " +  d + ", max diameter - " + maxDiameter);
	}

	private static void run2() {
		TreeNode<Integer> n1 = new TreeNode<>(1);

		TreeNode<Integer> n2 = n1.left(2);

		TreeNode<Integer> n4 = n2.left(4);
		TreeNode<Integer> n5 = n2.right(5);

		TreeNode<Integer> n8 = n4.left(8);
		n8.left(10);

		TreeNode<Integer> n9 = n5.left(9);
		n9.left(11);

		TreeNode<Integer> n3 = n1.right(3);
		TreeNode<Integer> n6 = n3.left(6);
		n6.right(12);
		n3.right(7);

		BTreePrinter.printNode(n1);
		int d = diameter(n1);
		System.out.println("Run2: diameter - " +  d + ", max diameter - " + maxDiameter);
	}

	private static int maxDiameter = 0;

	private static int diameter(TreeNode<Integer> node) {
		int leftDiameter = node.left == null ? 0 : (diameter(node.left) + 1);
		int rightDiameter = node.right == null ? 0 : (diameter(node.right) + 1);
		int diameter = leftDiameter + rightDiameter;
		maxDiameter = Math.max(diameter, maxDiameter);
		return Math.max(leftDiameter, rightDiameter);
	}
}
