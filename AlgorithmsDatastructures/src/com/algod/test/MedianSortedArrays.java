package com.algod.test;

public class MedianSortedArrays {

	public static void main(String[] args) {
		int [] nums1 = {1, 2, 5};
		int [] nums2 = {3, 6, 7, 9};
		System.out.println(findMedianSortedArrays(nums1, nums2));

		nums1 = new int [] {2};
		nums2 = new int [] {};
		System.out.println(findMedianSortedArrays(nums1, nums2));

		nums1 = new int [] {};
		nums2 = new int [] {3};
		System.out.println(findMedianSortedArrays(nums1, nums2));

		nums1 = new int [] {2};
		nums2 = new int [] {3};
		System.out.println(findMedianSortedArrays(nums1, nums2));

		nums1 = new int [] {};
		nums2 = new int [] {};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int []  nums1, int [] nums2) {
		if (nums1.length == 0 && nums2.length == 0) {
			return -1;
		}
		if (nums2.length == 0) {
			return findMedianOfSortedArray(nums1);
		}
		if (nums1.length == 0) {
			return findMedianOfSortedArray(nums2);
		}
		int total = nums1.length + nums2.length;
		int cutoff = total / 2;
		boolean odd = true;
		if (total % 2 == 0) {
			odd = false;
		}
		
		double median = 0;
		boolean done = false;
		int i1=0;
		int i2=0;
		int iters=-1;
		int prev=-1;
		while(!done) {
			int current = -1;
			if (i1 == nums1.length) {
				current = nums2[i2];
				i2++;
			} else if (i2 == nums2.length) {
				current = nums1[i1];
				i1++;
			} else if (nums1[i1] <= nums2[i2]) {
				current = nums1[i1];
				i1++;
			} else {
				current = nums2[i2];
				i2++;
			}
			if (++iters == cutoff) {
				if (odd) {
					median = current;
				} else {
					median = (prev + current) / 2.0;
				}
				done = true;
			}
			prev = current;
		}
		return median;
	}
	
	private static double findMedianOfSortedArray(int [] nums) {
		if (nums.length == 0) return -1;
		if (nums.length == 1) return nums[0];
		
		int mid = nums.length/2;
		if (nums.length % 2 == 0) {
			return ((nums[mid] + nums[mid-1])/2.0);
		} else {
			return nums[mid];
		}
	}
}
