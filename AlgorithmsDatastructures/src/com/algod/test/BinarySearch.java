package com.algod.test;

public class BinarySearch {

	public static void main(String[] args) {
		System.out.println(binarySearch(new int[] {0, 1,2,3,4}, 40));
		System.out.println(binarySearch(new int[] {0, 1,2,3,4}, -1));
		System.out.println(binarySearch(new int[] {0, 1,2,3,4}, 4));
		System.out.println(binarySearch(new int[] {0, 1,2,3,4}, 0));
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

}
