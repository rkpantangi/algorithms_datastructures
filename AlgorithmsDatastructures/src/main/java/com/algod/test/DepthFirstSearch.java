package com.algod.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class DepthFirstSearch {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("1", "2");
		list.forEach(System.out::println);
		
		for (String x : list) {
			System.out.println(x);
		}

		class CompInt {
			public int compare(Comparator<Integer> cmp) {
				return cmp.compare(2, 3);
			}
		}

		Comparator<Integer> ci = (p1, p2) -> p1 - p2;
		System.out.println(new CompInt().compare(ci));
		
	}
}
