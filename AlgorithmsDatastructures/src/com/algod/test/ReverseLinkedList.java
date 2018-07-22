package com.algod.test;

import com.algod.util.LinkedNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
//		Node n4 = new Node(4, null);
//		Node n3 = new Node(3, n4);
//		Node n2 = new Node(2, n3);
//		Node n1 = new Node(1, n2);
		
		LinkedNode n1 = new LinkedNode(1);
		n1.next(new LinkedNode(2)).next(new LinkedNode(3)).next(new LinkedNode(4));

		printList(n1);
		
		LinkedNode nhead = reverse(n1);
		
		printList(nhead);
	}
	
	private static void printList(LinkedNode node) {
		if (node == null) return;
		System.out.println(node.val);
		printList(node.next);
	}
	
	private static LinkedNode reverse(LinkedNode head) {
		LinkedNode current = head; // 1
		LinkedNode prev = null; // null
		while(true) {
			LinkedNode next = current.next; // 2
			current.next = prev; // 2
			prev = current; 
			if (next == null) break;
			current = next; // 2
		}
		return current;
	}

}
