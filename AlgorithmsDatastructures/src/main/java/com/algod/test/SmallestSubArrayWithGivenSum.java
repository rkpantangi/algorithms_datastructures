package com.algod.test;

/**
 * Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray
 * whose sum is greater than or equal to ‘S’. Return 0 if no such subarray exists.
 * This is a two pointer approach
 * @author Ram
 *
 */
public class SmallestSubArrayWithGivenSum {

	public static void main(String[] args) {
		smallestSubArrayWithGivenSum(new int [] {2, 1, 5, 2, 3, 2}, 7);

		smallestSubArrayWithGivenSum(new int [] {2, 1, 5, 2, 8}, 7);

		smallestSubArrayWithGivenSum(new int [] {3, 4, 1, 1, 6}, 7);
	}

	private static void smallestSubArrayWithGivenSum(int[] a, int target) {
		int minlength = Integer.MAX_VALUE;
		int minst=-1;
		int minend=-1;
		int st=0;
		int windowSum = 0;
		for (int end=0;end<a.length;end++) {
			windowSum += a[end];

			while (windowSum >= target) {
				int length = end - st + 1;
				if (length < minlength) {
					minst = st;
					minend = end;
					minlength = length;
				}
				windowSum -= a[st];
				st++;
			}
		}

		System.out.println("smallest sub array: st - " + minst + ", end - " + minend);
	}
}
