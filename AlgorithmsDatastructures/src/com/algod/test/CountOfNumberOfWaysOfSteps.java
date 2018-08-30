package com.algod.test;

/**
 * Number of ways to climb a stair case when one can hop either 1 or 2 or 3 steps at a time.
 */
public class CountOfNumberOfWaysOfSteps {

	public static void main(String[] args) {
		System.out.println(countSteps(0));
		System.out.println(countSteps(1));
		System.out.println(countSteps(2));
		System.out.println(countSteps(4));
	}

	private static int countSteps(int n) {
		if (n <= 1) return 1;
		
		if (n == 2) {
			return 2;
		}
		
		return countSteps(n-3) + countSteps(n-2) + countSteps(n-1);
	}
}
