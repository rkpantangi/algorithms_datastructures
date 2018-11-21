package com.algod.test;

import com.algod.util.LinkedNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
//		Node n4 = new Node(4, null);
//		Node n3 = new Node(3, n4);
//		Node n2 = new Node(2, n3);
//		Node n1 = new Node(1, n2);
		
		LinkedNode<Integer> n1 = new LinkedNode<>(1);
		n1.next(new LinkedNode<>(2)).next(new LinkedNode<>(3)).next(new LinkedNode<>(4));

		printList(n1);
		
		LinkedNode<Integer> nhead = reverse(n1);
		
		printList(nhead);
	}
	
	private static void printList(LinkedNode<Integer> node) {
		if (node == null) return;
		System.out.println(node.val);
		printList(node.next);
	}
	
	private static LinkedNode<Integer> reverse(LinkedNode<Integer> head) {
		LinkedNode<Integer> current = head; // 1
		LinkedNode<Integer> prev = null; // null
		while(true) {
			LinkedNode<Integer> next = current.next; // 2
			current.next = prev; // 2
			prev = current; 
			if (next == null) break;
			current = next; // 2
		}
		return current;
	}

}
