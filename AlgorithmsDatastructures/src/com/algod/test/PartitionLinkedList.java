package com.algod.test;

import com.algod.util.LinkedNode;

/**
 * Partition a LinkedList at a number.
 */
public class PartitionLinkedList {

	public static void main(String[] args) {
		LinkedNode<Integer> n1 = new LinkedNode<>(3);
		LinkedNode<Integer> n2 = new LinkedNode<>(5);
		LinkedNode<Integer> n3 = new LinkedNode<>(8);
		LinkedNode<Integer> n4 = new LinkedNode<>(5);
		LinkedNode<Integer> n5 = new LinkedNode<>(10);
		LinkedNode<Integer> n6 = new LinkedNode<>(2);
		LinkedNode<Integer> n7 = new LinkedNode<>(1);
		
		n1.next(n2).next(n3).next(n4).next(n5).next(n6).next(n7);
		
		System.out.println(n1);
				
		System.out.println(partition(n1, 5));
	}
	
	private static LinkedNode<Integer> partition(LinkedNode<Integer> head, int split) {
		LinkedNode<Integer> lowh = null;
		LinkedNode<Integer> highh = null;

		LinkedNode<Integer> low = null;
		LinkedNode<Integer> high = null;
		
		while(head != null) {
			LinkedNode<Integer> nhead = head.next;
			if (head.val < split) {
				if (lowh == null) {
					low = lowh = head;					
					low.next = null;
				} else {
					low.next = head;
					low = head;
					low.next = null;
				}
			} else {
				if (highh == null) {
					high = highh = head;					
					high.next = null;
				} else {
					high.next = head;
					high = head;
					high.next = null;
				}
			}
			head = nhead;
		}
		
		if (lowh == null) return highh;
		if (highh == null) return lowh;
		low.next = highh;
		return lowh;
	}
	
	

}
