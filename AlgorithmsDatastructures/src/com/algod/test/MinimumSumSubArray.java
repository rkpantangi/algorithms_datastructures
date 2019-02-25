package com.algod.test;

import java.util.Arrays;

/**
 * Given an array of Integers, find minimum sum sub-array of given size k
 * @author Ram
 *
 */
public class MinimumSumSubArray {

	public static void main(String[] args) {
		int arr [] = new int [] {10, 4, 2, 5, 6, 3, 8, 1};
		minSumSubArray(arr, 3);
		
		arr = new int [] {10, 5, 6, 3, 8, 1, 4, 2, 5};
		minSumSubArray(arr, 3);

	}

	private static void minSumSubArray(int [] arr, int k) {
		int minsum = Integer.MIN_VALUE;
		int mins = -1;
		int mine = -1;
		if (arr.length >= k) {
			mins = 0;
			mine = k-1;
			minsum = Arrays.stream(arr).limit(k).sum();
			int cursum = minsum;
			for (int i=1;i<=(arr.length - k);i++) {
				int end = i+k-1;
				cursum -= arr[i-1];
				cursum += arr[end];
				if (cursum < minsum) {
					minsum = cursum;
					mins = i;
					mine = end;
				}
			}
		}
		
		System.out.println("Min sum - " + minsum + ", mins - " + mins + ", mine - " + mine);
	}
}
