package com.algod.test.search;

/**
 * Given a sorted array of strings that is interspersed with empty strings, write a method to find the location of a given string
 */
public class SparseBinarySearch {

	public static void main(String[] args) {
		String [] arr = new String[] {"abc", "", "", "", "cake", "", "", "kite", "ten", "", "", "xyz"};
		System.out.println(sparseBinarySearch(arr, "abc", 0, arr.length-1));
		System.out.println(sparseBinarySearch(arr, "pqr", 0, arr.length-1));
		System.out.println(sparseBinarySearch(arr, "kite", 0, arr.length-1));
		System.out.println(sparseBinarySearch(arr, "ten", 0, arr.length-1));
		System.out.println(sparseBinarySearch(arr, "xyz", 0, arr.length-1));
	}

	private static int sparseBinarySearch(String[] arr, String elem, int left, int right) {
		int mid = (left + right)/2;
		if (arr[mid].equals(elem)) {
			return mid;
		}
		if (left > right) {
			return -1;
		}
		
		if ("".equals(arr[mid])) {
			int ml = mid-1;
			int mr = mid+1;
			while(true) {
				if (ml < left && mr > right) {
					return -1;
				}
				if (ml >= left && !arr[ml].isEmpty()) {
					mid = ml;
					break;
				}
				if (mr <= right && !arr[mr].isEmpty()) {
					mid = mr;
					break;
				}
				ml--;
				mr++;
			}
		}
		
		if (arr[mid].equals(elem)) return mid;
		if (arr[mid].compareTo(elem) < 0) {
			return sparseBinarySearch(arr, elem, mid+1, right);
		} else {
			return sparseBinarySearch(arr, elem, left, mid-1);
		}
	}

}
