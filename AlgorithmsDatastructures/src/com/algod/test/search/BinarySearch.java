package com.algod.test.search;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] {0, 1,2,3,4}, 40));
		System.out.println(binarySearch(new int[] {0, 1,2,3,4}, -1));
		System.out.println(binarySearch(new int[] {0, 1,2,3,4}, 4));
		System.out.println(binarySearch(new int[] {0, 1,2,3,4}, 0));
		
		System.out.println(recursiveBinarySearch(new int[] {0, 1,2,3,4}, 40, 0, 4));
		System.out.println(recursiveBinarySearch(new int[] {0, 1,2,3,4}, -1, 0, 4));
		System.out.println(recursiveBinarySearch(new int[] {0, 1,2,3,4}, 4, 0, 4));
		System.out.println(recursiveBinarySearch(new int[] {0, 1,2,3,4}, 0, 0, 4));
	}
	
	private static int binarySearch(int [] nums, int elem) {
		int s = 0;
		int e = nums.length-1;
		while(true) {
			if (s>= nums.length || e < 0) break;
			int mid = (s + e)/2;	
			if (nums[mid] == elem) {
				return mid;
			} else if (nums[mid] < elem) {
				s = mid+1;
			} else {
				e = mid-1;
			}
		}
		return -1;
	}

	private static int recursiveBinarySearch(int [] nums, int elem, int st, int end) {
		if (st > end) return -1;
		int mid = (st + end)/2;
		if (nums[mid] == elem) return mid;
		if (nums[mid] < elem) {
			return recursiveBinarySearch(nums, elem, mid+1, end);
		} else {
			return recursiveBinarySearch(nums, elem, st, mid-1);
		}
	}
}
