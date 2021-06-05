package com.algod.test;

/**
 * Given an array of Integers, find minimum sum sub-array of given size k
 * @author Ram
 *
 */
public class MinimumSumSubArraySizeK {

	public static void main(String[] args) {
		int arr [] = new int [] {10, 4, 2, 5, 6, 3, 8, 1};
		minSumSubArray(arr, 3);
		
		arr = new int [] {10, 5, 6, 3, 8, 1, 4, 2, 5};
		minSumSubArray(arr, 3);
	}

	private static void minSumSubArray(int [] arr, int k) {
		int minsum = Integer.MAX_VALUE;
		int mins = 0;
		int mine = 0;

		int windowSum=0;
		int st=0;
		for (int i=0;i<arr.length;i++) {
			windowSum += arr[i];
			if (i >= k-1) {
				if (windowSum < minsum) {
					mins = st;
					mine = i;
					minsum = windowSum;
				}
				windowSum -= arr[st];
				st++;
			}
		}
		System.out.println("Min sum - " + minsum + ", mins - " + mins + ", mine - " + mine);
	}
}
