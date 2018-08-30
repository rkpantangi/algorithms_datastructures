package com.algod.test.sorting;

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		int [] arr = new int [] {6,5,4,3,2,1};
		heapSort(arr);
		System.out.println("Sorted arr: " + Arrays.toString(arr));

		arr = new int[] {6, 2, 5, 4, 5, 1, 6};
		heapSort(arr);
		System.out.println("Sorted arr: " + Arrays.toString(arr));
	}
	
	private static void heapSort(int [] arr) {
		int n = arr.length;
		for (int i=n/2-1;i>=0;i--) {
			heapify(arr, i, n);
		}
		
		for (int i=n-1;i>=0;i--) {
			swap(arr, 0, i);
			
			heapify(arr, 0, i);
		}			
	}
	
	private static void heapify(int [] arr, int root, int n) {
		int largest = root;
		int left = 2*root + 1;
		int right = 2*root + 2;
		
		if (left < n && arr[left] > arr[largest]) {
			largest = left;
		}
		if (right < n && arr[right] > arr[largest]) {
			largest = right;
		}
		if (largest != root) {
			swap(arr, largest, root);
			heapify(arr, largest, n);
		}
	}

	private static void swap(int [] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
}
