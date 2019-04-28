package com.algod.util;

/**
 *
 */
public class InvertedTreeNode {
	int data;
	InvertedTreeNode parent;
	
	public InvertedTreeNode(int data, InvertedTreeNode parent) {
		super();
		this.data = data;
		this.parent = parent;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public InvertedTreeNode getParent() {
		return parent;
	}

	public void setParent(InvertedTreeNode parent) {
		this.parent = parent;
	}

	public InvertedTreeNode(int data) {
		super();
		this.data = data;
	}
	
	@Override
	public String toString() {
		return " [" + data + "]";
	}

	public void printTree() {
		System.out.println(" data - " + data);
		if (parent != null) parent.printTree();
	}
}