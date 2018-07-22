package com.algod.test;

import com.algod.util.LinkedNode;

/**
 * 
 */
public class LinkedListNumberSum {

	public static void main(String[] args) {
		LinkedNode<Integer> n1 = LinkedNode.createLinkedNodeList(7, 1, 6); 
		System.out.println(n1);
		
		LinkedNode<Integer> n2 = LinkedNode.createLinkedNodeList(5, 9, 2);
		System.out.println(n2);
		
		approach1(n1, n2);
		approach2(n1, n2);
		
		n1 = LinkedNode.createLinkedNodeList(7, 1, 6);
		System.out.println(n1);
		n2 = LinkedNode.createLinkedNodeList(5, 9);
		System.out.println(n2);
		approach1(n1, n2);
		approach2(n1, n2);
		
		approach1(n2, n1);
		approach2(n2, n1);

	}
	
	private static void approach2(LinkedNode<Integer> n1, LinkedNode<Integer> n2) {
		LinkedNode<Integer> n3 = null;
		LinkedNode<Integer> run3 = null;
		int carry = 0;
		while (n1 != null || n2 != null) { 
			int val1 = 0;
			if (n1 != null) {
				val1 = n1.val;
				n1 = n1.next;
			}
			int val2 = 0;
			if (n2 != null) {
				val2 = n2.val;
				n2 = n2.next;
			}
			int total = val1+val2+carry;
			carry = total/10;
			LinkedNode<Integer> n = new LinkedNode<Integer>(total%10);
			if (n3 == null) {
				n3 = n; 
			} else {
				run3.next(n);
			}
			run3 = n;
		}
		System.out.println(n3);
		System.out.println(numFromLinkedList(n3));
	}
	
	private static void approach1(LinkedNode<Integer> n1, LinkedNode<Integer> n2) {
		int num1 = numFromLinkedList(n1);
		int num2 = numFromLinkedList(n2);
		
		int total = num1+num2;
		System.out.println("total1 - " + total);
		LinkedNode<Integer> n3 = linkedListFromNum(total);
		System.out.println(n3);
	}
	
	private static LinkedNode<Integer> linkedListFromNum(int total) {
		LinkedNode<Integer> head = null;
		LinkedNode<Integer> running = null;
		while (total > 0) {
			int rem = total%10;
			LinkedNode<Integer> n = new LinkedNode<Integer>(rem);
			if (head != null) {
				running.next(n);
			} else {
				head = n;
			}
			running = n;
			total = total/10;			
		}
		return head;
	}
	
	private static int numFromLinkedList(LinkedNode<Integer> n) {
		int num1=0;
		LinkedNode<Integer> run1 = n;
		int pow = 1;
		while (run1 != null) {
			num1 += (run1.val * pow);
			run1 = run1.next;
			pow *= 10;
		}
		
		System.out.println(num1);
		return num1;
	}

}
