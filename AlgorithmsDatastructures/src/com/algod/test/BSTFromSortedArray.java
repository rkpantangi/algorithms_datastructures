package com.algod.test;

import java.util.Arrays;

import com.algod.util.BTreePrinter2;
import com.algod.util.TreeNode;

public class BSTFromSortedArray {

	public static void main(String[] args) {
		int arr[] = new int [] {1, 2, 3, 4, 5, 6};
		TreeNode<Integer> head = createBSTFromArray(arr, 0, arr.length-1);
		
		BTreePrinter2.printNode(head);
	}
	
	private static TreeNode<Integer> createBSTFromArray(int [] arr, int st, int end) {

		if (st > end) {
			return null;
		}
		int mid = (st + end)/2;
		System.out.println(Arrays.toString(new int[] {mid, st, end}));
		TreeNode<Integer> t = new TreeNode<>(arr[mid]);
		
		t.left = createBSTFromArray(arr, st, mid-1);
		
		t.right = createBSTFromArray(arr, mid+1, end);
		return t;
	}

}
