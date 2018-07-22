package com.algod.test;

import com.algod.util.BTreePrinter;
import com.algod.util.TreeNode;

public class DiameterOfBinaryTree {

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
		
		TreeNode<Integer> n10 = n6.left(new TreeNode<Integer>(10));
		TreeNode<Integer> n11 = n7.right(new TreeNode<Integer>(11));
		
		TreeNode<Integer> n12 = n9.left(new TreeNode<Integer>(12));
		TreeNode<Integer> n13 = n12.right(new TreeNode<Integer>(13));
		
		BTreePrinter.printNode(n1);
		Data d = diameter(n1);
		System.out.println("diameter - " +  d.diameter + ", height - " + d.height);

	}
	
	private static class Data {
		int diameter;
		int height = -1;
		int from;
		int to;
		
		public Data() {
			super();
		}

		public Data(int diameter, int height, int from, int to) {
			super();
			this.diameter = diameter;
			this.height = height;
			this.from = from;
			this.to = to;
		}

		@Override
		public String toString() {
			return "Data [diameter=" + diameter + ", height=" + height + ", from=" + from + ", to=" + to + "]";
		}

	}
	
	private static Data diameter(TreeNode<Integer> node) {
		Data ld = new Data(), rd = new Data();
		if (node.left != null) {
			ld = diameter(node.left);
			System.out.println("left data - " + ld);
		}
		if (node.right != null) {
			rd = diameter(node.right);
			System.out.println("right data - " + rd);
		}
		
		Data ret = new Data();
		ret.from = ret.to = node.data;
		int md = 0;
		if (ld.diameter > rd.diameter) {
			md = ld.diameter;
			ret.from = ld.from;
			ret.to = ld.to;
		} else {
			if (node.right != null) {
				md = rd.diameter;
				ret.from = rd.from;
				ret.to = rd.to;
			}
		}
		int mh = ld.height + 1 + rd.height + 1;
		if (mh > md) {
			md = mh;
			if (node.left != null) {
				ret.from = ld.from;
			}
			
			if (node.right != null) {
				ret.to = rd.to;
			}
		}
//		int md = Math.max(ld.height + 1 + rd.height + 1, Math.max(ld.diameter, rd.diameter));
//		Data ret = new Data(md, Math.max(ld.height, rd.height) + 1);
		ret.diameter = md;
		ret.height = Math.max(ld.height, rd.height) + 1;
		System.out.println("----------------node - " + node.data + ", ret - " + ret);
		return ret;
	}
}
