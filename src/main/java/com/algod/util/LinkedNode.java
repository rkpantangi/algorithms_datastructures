package com.algod.util;

import java.util.List;

public class LinkedNode<T> {
	public T val;
	public LinkedNode<T> next;
	
	public LinkedNode(T val) {
		super();
		this.val = val;
	}

	public static <T> LinkedNode<T> createLinkedNodeList(@SuppressWarnings("unchecked") T ... vals) {
		LinkedNode<T> head = null;
		LinkedNode<T> running = null;
		for (T val : vals) {
			LinkedNode<T> n = new LinkedNode<T>(val);
			if (head == null) {
				head = n;				
			} else {				
				running.next = n;
			}
			running = n;
		}
		return head;
	}
	
	public LinkedNode(T val, LinkedNode<T> next) {
		super();
		this.val = val;
		this.next = next;
	}

	public LinkedNode<T> next(LinkedNode<T> next) {
		this.next = next;
		return next;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(100);
		LinkedNode<T> n = this;
		while (n != null) {
			sb.append(n.val + " -> ");
			n = n.next;
		}
		sb.append("null");
		return sb.toString();
	}
}
