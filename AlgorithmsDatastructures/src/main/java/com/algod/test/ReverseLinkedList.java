package com.algod.test;

import com.algod.util.LinkedNode;

public class ReverseLinkedList {

	public static void main(String[] args) {
		LinkedNode<Integer> n1 = LinkedNode.createLinkedNodeList(1, 2, 3, 4);
		printList(n1);
		System.out.println("----------------------------------");
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
