package com.algod.test;

import java.util.ArrayList;
import java.util.List;

import com.algod.util.BTreePrinter;
import com.algod.util.TreeNode;

public class BinaryTreeSerDeserialization {

	
	public static void main(String[] args) {
		TreeNode<Integer> n1 = new TreeNode<>(1);
		TreeNode<Integer> n2 = new TreeNode<Integer>(2);
		TreeNode<Integer> n3 = new TreeNode<Integer>(3);
		TreeNode<Integer> n4 = new TreeNode<Integer>(4);
		TreeNode<Integer> n5 = new TreeNode<Integer>(5);
		TreeNode<Integer> n6 = new TreeNode<Integer>(6);
		TreeNode<Integer> n7 = new TreeNode<Integer>(7);
		
		n1.left(n2);
		n1.right(n3);
		
		n2.left(n4);
		n2.right(n5);
		
		n4.left(n7);
		
		n3.right(n6);
		
		ArrayList<Integer> list = new ArrayList<>();
		serialize(n1, list);
		
		System.out.println("serialized binary tree - " + list);
		
		TreeNode<Integer> n = deserialize(list, new int[1]);
		
		BTreePrinter.printNode(n);
	}
	
	private static void serialize(TreeNode<Integer> n, List<Integer> list) {
		if (n == null) {
			list.add(-1);
			return;
		} else {
			list.add(n.data);
		}
		serialize(n.left, list);
		serialize(n.right, list);
	}

	private static TreeNode<Integer> deserialize(List<Integer> list, int counter[]) {
		int index = counter[0];
		if (index >= list.size() || list.get(index) == -1) return null;

		TreeNode<Integer> n = new TreeNode<>(list.get(index));
		counter[0] = counter[0]+1;
		n.left = deserialize(list, counter);
		counter[0] = counter[0]+1;
		n.right = deserialize(list, counter);
		return n;
	}

}
