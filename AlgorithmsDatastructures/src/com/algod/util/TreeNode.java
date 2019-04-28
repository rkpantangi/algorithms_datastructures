package com.algod.util;

public class TreeNode<T> {
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
	
	public TreeNode(T val) {
		super();
		this.data = val;
	}
	
	public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
		super();
		this.data = val;
		this.left = left;
		this.right = right;
	}

	public TreeNode<T> left(TreeNode<T> left) {
		this.left = left;
		return left;
	}

	public TreeNode<T> right(TreeNode<T> right) {
		this.right = right;
		return right;
	}

	@Override
	public String toString() {
		return "[" + data + "]";
	}
}
