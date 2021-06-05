package com.algod.test;

public class MedianSortedArraysLogn {

	public static void main(String[] args) {
		int [] nums1 = {1, 2, 5};
		int [] nums2 = {3, 6, 7, 9};
		System.out.println(findMedianSortedArrays(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1));

//		nums1 = new int [] {2};
//		nums2 = new int [] {};
//		System.out.println(findMedianSortedArrays(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1));

//		nums1 = new int [] {};
//		nums2 = new int [] {3};
//		System.out.println(findMedianSortedArrays(nums1, nums2));
//
//		nums1 = new int [] {2};
//		nums2 = new int [] {3};
//		System.out.println(findMedianSortedArrays(nums1, nums2));
//
//		nums1 = new int [] {};
//		nums2 = new int [] {};
//		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

	public static double findMedianSortedArrays(int [] nums1, int i, int j, int [] nums2, int m, int n) {
		if (nums1.length == 2 && nums2.length == 2) {
			return -1;
		}
		
		double m1 = findMedianOfSortedArray(nums1, i, j);
		double m2 = findMedianOfSortedArray(nums2, m, n);
		
		if (m1 < m2) {
			return findMedianSortedArrays(nums1, (i+j)/2, j, nums2, 0, (m+n)/2);
		} else if (m1 > m2) {
			return findMedianSortedArrays(nums1, 0, (i+j)/2, nums2, (m+n)/2, n);
		} else {
			return m1;
		}
	}
	
	private static double findMedianOfSortedArray(int [] nums, int i, int j) {
		int length = j-i+1;
		if (length == 0) return -1;
		if (length == 1) return nums[0];
		
		int mid = (i+j)/2;
		if (length % 2 == 0) {
			return ((nums[mid] + nums[mid+1])/2.0);
		} else {
			return nums[mid];
		}
	}
}
