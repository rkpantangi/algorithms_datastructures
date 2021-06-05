package com.algod.test;

import com.algod.util.InvertedTreeNode;

/**
 * Common ancestor of two nodes in a binary tree, when the tree is given in a InvertedNode format.
 */
public class CommonAncestorOfNodes {

	public static void main(String[] args) {
		approach1();
	}
	
	/**
	 * Assuming Nodes have links to parents
	 */
	private static void approach1() {
		InvertedTreeNode n1 = new InvertedTreeNode(1);
		InvertedTreeNode n2 = new InvertedTreeNode(2, n1);
		InvertedTreeNode n3 = new InvertedTreeNode(3, n1);
		InvertedTreeNode n4 = new InvertedTreeNode(4, n2);
		InvertedTreeNode n5 = new InvertedTreeNode(5, n2);
		InvertedTreeNode n6 = new InvertedTreeNode(6, n3);
		InvertedTreeNode n7 = new InvertedTreeNode(7, n4);
		InvertedTreeNode n8 = new InvertedTreeNode(8, n5);
		
		findCommonAncestor(n6, n7);
		findCommonAncestor(n4, n6);
		findCommonAncestor(n3, n8);
		findCommonAncestor(n7, n8);
	}
	
	private static void findCommonAncestor(InvertedTreeNode p, InvertedTreeNode q) {
		InvertedTreeNode parp = p;
		InvertedTreeNode parq = q;

		int depthP = getDepth(parp);
		int depthQ = getDepth(parq);
		
		if (depthP > depthQ) {
			// move P up
			for (int i=1;i<=(depthP-depthQ);i++) {
				parp = parp.getParent();
			}
		} else if (depthP < depthQ) {
			// move Q up
			for (int i=1;i<=(depthQ-depthP);i++) {
				parq = parq.getParent();
			}
		}
		
		// find common ancestor
		InvertedTreeNode ancestor = null;
		while (true) {
			parp = parp.getParent();
			if (parp == null) break;
			parq = parq.getParent();
			if (parq == null) break;
			
			if (parp.equals(parq)) {
				ancestor = parp;
				break;
			}
		}
		
		System.out.println("Common ancestor of " + p + " and " + q + " is - " + ancestor);
	}
	
	private static int getDepth(InvertedTreeNode p) {
		InvertedTreeNode root = p;
		int depth = -1;
		while (root != null) {
			root = root.getParent();
			depth++;
		}
		return depth;
	}

}
