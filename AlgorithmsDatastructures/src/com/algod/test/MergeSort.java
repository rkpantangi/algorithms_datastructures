package com.algod.test;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int [] arr = new int[] {2, 1, 5, 6, 2, 3};
		mergeSort(arr, 0, arr.length-1);
		System.out.println("Sorted - " + Arrays.toString(arr));

		arr = new int[] {6, 2, 5, 4, 5, 1, 6};
		mergeSort(arr, 0, arr.length-1);
		System.out.println("Sorted - " + Arrays.toString(arr));

		arr = new int[] {12, 11, 13, 5, 6, 7};
		mergeSort(arr, 0, arr.length-1);
		System.out.println("Sorted - " + Arrays.toString(arr));
	}

	private static void mergeSort(int [] hist, int st, int end) {
		if (st == end) {
			return;
		} else {
			int mid = (st + end)/2;
			int lst = st;
			int lend = mid;
			boolean left=false;
			if (lst <= lend) {
				left=true;
				mergeSort(hist, lst, lend);
			}

			int rst = mid+1;
			int rend = end;
			boolean right=false;
			if (rst <= rend) {
				right = true;
				mergeSort(hist, rst, rend);
			}			
			
			if (left && right) {
				merge(hist, lst, lend, rst, rend);
			}
		}
	}
	
	private static void merge(int [] arr, int lst, int lend, int rst, int rend) {
		if (arr[lend] <= arr[rst]) return;
		int [] narr = new int[rend-lst+1];
		int i=lst;
		int j=rst;
		int k=0;
		while(k<narr.length) {
			if (i<=lend && j<=rend) {
				if (arr[i] < arr[j]) {
					narr[k++] = arr[i++];
				} else {
					narr[k++] = arr[j++];
				}
			} else if (i<=lend) {
				narr[k++] = arr[i++];
			} else if (j<=rend) {
				narr[k++] = arr[j++];
			}
		}
		for (int x=0;x<narr.length;x++) {
			arr[lst+x] = narr[x];
		}
	}
}
