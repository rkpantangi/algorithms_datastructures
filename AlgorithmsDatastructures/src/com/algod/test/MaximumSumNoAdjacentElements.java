package com.algod.test;

/**
 * Given an array of positive numbers, find the Maximum sum of a subsequence with the constraint that no 2 numbers in the sequence should be adjacent in the array.
 */
public class MaximumSumNoAdjacentElements {

	public static void main(String[] args) {
		int [] arr = new int[] {5, 5, 10, 100, 10, 5};
		System.out.println(maxSumNoAdjacentElements(arr));

		arr = new int[] {1, 2, 3};
		System.out.println(maxSumNoAdjacentElements(arr));
		
		arr = new int[] {1, 20, 3};		
		System.out.println(maxSumNoAdjacentElements(arr));

	}
	
	public static int maxSumNoAdjacentElements(int [] arr) {
		int incl = 0;
		int excl = 0;
		for (int i=0;i<arr.length;i++) {
			int nincl = excl + arr[i];
			int nexcl = incl;
			incl = nincl;
			excl = nexcl;
		}
		return Math.max(incl, excl);
	}

}
