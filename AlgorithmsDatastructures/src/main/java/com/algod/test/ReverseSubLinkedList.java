package com.algod.test;

import com.algod.util.LinkedNode;

public class ReverseSubLinkedList {

	public static void main(String[] args) {
		LinkedNode<Integer> n1 = LinkedNode.createLinkedNodeList(1, 2, 3, 4, 5);
		printList(n1);
		System.out.println("---------------------");
		LinkedNode<Integer> nhead = reverseSubLinkedList(n1, 2, 4);
		printList(nhead);

		System.out.println("---------------------");
		n1 = LinkedNode.createLinkedNodeList(1, 2, 3, 4, 5);
		printList(n1);
		System.out.println("---------------------");
		nhead = reverseSubLinkedList(n1, 1, 3);
		printList(nhead);

		System.out.println("---------------------");
		n1 = LinkedNode.createLinkedNodeList(1, 2, 3, 4, 5);
		printList(n1);
		System.out.println("---------------------");
		nhead = reverseSubLinkedList(n1, 2, 5);
		printList(nhead);

	}
	
	private static void printList(LinkedNode<Integer> node) {
		if (node == null) return;
		System.out.println(node.val);
		printList(node.next);
	}
	
	private static LinkedNode<Integer> reverseSubLinkedList(LinkedNode<Integer> head, int p, int q) {
		LinkedNode<Integer> current = head; // 1
		LinkedNode<Integer> prev = null; // null
		for (int i=1;i<p;i++) {
			prev = current;
			current = current.next;
		}
		LinkedNode<Integer> prev1 = null; // null
		LinkedNode<Integer> current1 = current; // null
		for (int i=1;(i<=(q-p+1) && current1 != null);i++) {
			LinkedNode<Integer> next = current1.next; // 2
			current1.next = prev1; // 2
			prev1 = current1;
			current1 = next; // 2
		}
		if (prev == null) {
			// flipping starting from head
			head = prev1;
		} else {
			prev.next = prev1;
		}
		if (current != null) {
			// flipping till the end of the list
			current.next = current1;
		}
		return head;
	}

}
