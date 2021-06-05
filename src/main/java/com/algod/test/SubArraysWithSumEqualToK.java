package com.algod.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers numbers and an integer k, return all the continuous sub arrays whose sum equals to k.
 * @author Ram
 *
 */
public class SubArraysWithSumEqualToK {

	public static void main(String[] args) {
		int arr [] = new int [] {1, 1, 1};
		subArraysSumK(arr, 2);
		
		arr = new int [] {1, 2, 3};
		subArraysSumK(arr, 3);

	}

	private static class Result {
		private int st;
		private int end;

		public Result(int st, int end) {
			this.st = st;
			this.end = end;
		}

		@Override
		public String toString() {
			return "{" +
					"st=" + st +
					", end=" + end +
					'}';
		}
	}

	private static void subArraysSumK(int [] arr, int k) {
		List<Result> results = new ArrayList<>();

		int cursum = 0;
		int st=0;
		for (int i=0;i<arr.length;i++) {
			cursum += arr[i];
			if (cursum < k) continue;

			if (cursum == k) {
				results.add(new Result(st, i));
			}
			cursum -= arr[st];
			st=st+1;
		}

		if (cursum == k) {
			results.add(new Result(st, st));
		}

		System.out.println(results);
	}

}
