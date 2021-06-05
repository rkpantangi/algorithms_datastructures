package com.algod.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// not done yet
public class PermutationOfNumbers {

	public static void main(String[] args) {
		List<List<Integer>> result = getPermutations(3, 0, 5);
		result.forEach(System.out::println);
	}

	private static List<List<Integer>> getPermutations(int length, int st, int end) {
		if (length == 0) return Collections.emptyList();
		List<List<Integer>> retLists = new ArrayList<>();
		for (int i=st;i<=end;i++) {
			List<List<Integer>> subLists = getPermutations(length-1, i+1, end);
			if (subLists.isEmpty()) {
				ArrayList<Integer> l = new ArrayList<>();
				l.add(i);
				retLists.add(l);
			} else {
				for (List<Integer> subList : subLists) {
					subList.add(i);
					retLists.add(subList);
				}
			}
		}
		return retLists;
	}
}