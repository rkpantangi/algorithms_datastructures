package com.algod.test.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int [] arr = new int [] {6,5,4,3,2,1};
		sort(arr);
		System.out.println("Sorted arr: " + Arrays.toString(arr));
	}
	
	private static void sort(int [] arr) {
		for (int i=0;i<arr.length-1;i++) {
			for (int j=i+1;j<arr.length;j++) {
				if (arr[i] > arr[j]) {
					// swap
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}

}
