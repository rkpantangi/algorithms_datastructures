package com.algod.test;

import com.algod.util.BTreePrinter;
import com.algod.util.TreeNode;

/**
 * Common ancestor of two nodes in a binary tree, when given the root node only.
 */
public class LowestCommonAncestorBinaryTree {

	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<>(1);
		TreeNode<Integer> n2 = n1.left(new TreeNode<Integer>(2));
		TreeNode<Integer> n3 = n1.right(new TreeNode<Integer>(3));
		
		TreeNode<Integer> n4 = n2.left(new TreeNode<Integer>(4));
		TreeNode<Integer> n5 = n2.right(new TreeNode<Integer>(5));
		
		TreeNode<Integer> n6 = n4.left(new TreeNode<Integer>(6));
		TreeNode<Integer> n7 = n4.right(new TreeNode<Integer>(7));
		
		TreeNode<Integer> n8 = n5.left(new TreeNode<Integer>(8));
		TreeNode<Integer> n9 = n5.right(new TreeNode<Integer>(9));
		
		n6.left(new TreeNode<Integer>(10));
		n7.right(new TreeNode<Integer>(11));
		
		TreeNode<Integer> n12 = n9.left(new TreeNode<Integer>(12));
		TreeNode<Integer> n13 = n12.right(new TreeNode<Integer>(13));
		
		BTreePrinter.printNode(n1);
		
		TreeNode<Integer> one;
		TreeNode<Integer> two;
		
		one = n1;
		two = n12;
		Data d = lcaBinaryTree(n1, one, two);		
		System.out.println((d.type == 2) ? "Common ancestor of " + one + " and " + two + " is - " + d.node : "No Common Ancestor");
		
		one = n4;
		two = n3;
		d = lcaBinaryTree(n1, one, two);		
		System.out.println((d.type == 2) ? "Common ancestor of " + one + " and " + two + " is - " + d.node : "No Common Ancestor");

		one = n8;
		two = n13;
		d = lcaBinaryTree(n1, one, two);		
		System.out.println((d.type == 2) ? "Common ancestor of " + one + " and " + two + " is - " + d.node : "No Common Ancestor");
		
		one = n8;
		two = new TreeNode<Integer>(18);
		d = lcaBinaryTree(n1, one, two);		
		System.out.println((d.type == 2) ? "Common ancestor of " + one + " and " + two + " is - " + d.node : "No Common Ancestor");
	}

	private static class Data {
		TreeNode<Integer> node;
		int type;
	}
	
	private static Data lcaBinaryTree(TreeNode<Integer> n, TreeNode<Integer> one, TreeNode<Integer> two) {
		if (n == null) return new Data();
		
		Data d = new Data();
		int val = ((n.data == one.data) || (n.data == two.data)) ? 1: 0;
		Data lval = lcaBinaryTree(n.left, one, two);
		
		if (lval.type == 2) {
			return lval;			
		}
		
		if (val + lval.type == 2) {
			// found both, terminate
			d.node=n;
			d.type=2;
			return d;
		}
		
		Data rval = lcaBinaryTree(n.right, one, two);
		if (rval.type == 2) {
			return rval;
		}
		
		if (val + lval.type + rval.type == 2) {
			// found both, terminate
			d.node=n;
			d.type=2;
			return d;
		}
		
		if (val == 1) {
			d.node=n;
		} else if (lval.type == 1) {
			d.node = lval.node;
		} else if (rval.type == 1) {
			d.node = lval.node;
		} else {
			d.node = n;
		}
		d.type = val + lval.type + rval.type;
		return d;
	}

}
