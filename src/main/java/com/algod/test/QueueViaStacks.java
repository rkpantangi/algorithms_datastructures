package com.algod.test;

import java.util.Stack;

/**
 * The problem is opposite of this post. We are given a stack data structure with push and pop operations, the task is
 * to implement a queue using instances of stack data structure and operations on them.
 */
public class QueueViaStacks {
	Stack<Integer> first = new Stack<>();
	Stack<Integer> second = new Stack<>();

	public void add(Integer e) {
		first.add(e);
	}

	public Integer remove() {
		if (second.empty()) {
			while(!first.empty()) {
				second.push(first.pop());
			}
		}
		if (!second.empty()) {
			return second.pop();
		}
		return null;
	}

	public static void main(String[] args) {
		QueueViaStacks qs = new QueueViaStacks();
		qs.add(1);
		qs.add(2);
		qs.add(3);
		System.out.println(qs.remove());
		qs.add(4);
		System.out.println(qs.remove());
		qs.add(5);
		System.out.println(qs.remove());
		qs.add(6);
		System.out.println(qs.remove());
		System.out.println(qs.remove());
		System.out.println(qs.remove());
		qs.add(7);
		qs.add(8);
		System.out.println(qs.remove());
		qs.add(9);
		System.out.println(qs.remove());
		System.out.println(qs.remove());
	}
}
