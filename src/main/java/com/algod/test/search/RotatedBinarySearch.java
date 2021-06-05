package com.algod.test.search;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array. This works for an input with non-repeating values.
 */
public class RotatedBinarySearch {

	public static void main(String[] args) {
		int [] arr = new int[] {20, 21,22,23,4, 5, 6, 7, 8};
		System.out.println(rotatedBinarySearch(arr, 21, 0, arr.length-1));
		System.out.println(rotatedBinarySearch(arr, 4, 0, arr.length-1));
		System.out.println(rotatedBinarySearch(arr, 6, 0, arr.length-1));
		System.out.println(rotatedBinarySearch(arr, 8, 0, arr.length-1));
		System.out.println(rotatedBinarySearch(arr, 20, 0, arr.length-1));
	}

	private static int rotatedBinarySearch(int[] arr, int elem, int left, int right) {
		int mid = (left + right)/2;
		if (arr[mid] == elem) {
			return mid;
		}
		if (left > right) {
			return -1;
		}
		
		if (arr[left] <= arr[mid]) {
			// left side is a regular increasing array
			if (arr[left] <= elem && arr[mid] > elem) {
				return rotatedBinarySearch(arr, elem, left, mid-1);
			} else {
				return rotatedBinarySearch(arr, elem, mid+1, right);
			}
		} if (arr[left] > arr[mid]) {
			if (arr[mid] < elem && arr[right] >= elem) {
				return rotatedBinarySearch(arr, elem, mid+1, right);
			} else {
				return rotatedBinarySearch(arr, elem, left, mid-1);
			}
		}
		return -1;
	}

}
