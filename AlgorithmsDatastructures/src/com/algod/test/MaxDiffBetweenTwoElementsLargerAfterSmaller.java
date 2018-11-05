package com.algod.test;

/**
 * Given an array of positive integers, find the maximum difference between any 2 numbers with the constraint that Larger number should come after the smaller number.
 * This is similar to the maximum profit by selling at different points problem.
 */
public class MaxDiffBetweenTwoElementsLargerAfterSmaller {

	public static void main(String[] args) {
		int [] arr = new int[] {2, 3, 10, 6, 4, 8, 1};
		System.out.println(maxDiff(arr));

		arr = new int[] {7, 9, 5, 6, 3, 2};
		System.out.println(maxDiff(arr));
		
		arr = new int[] {7, 6, 5, 4, 3, 2};
		System.out.println(maxDiff(arr));
		
		arr = new int[] {2, 3, 4, 5, 6};
		System.out.println(maxDiff(arr));
	}
	
	public static int maxDiff(int [] arr) {
		int min = arr[0];
		int diff = -1;
		for (int i=1;i<arr.length;i++) {
			if (arr[i] > min) {
				diff = Math.max(diff, arr[i] - min);
			} else {
				min = arr[i];
			}
		}
		return diff;
	}

}
