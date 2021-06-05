package com.algod.test;

import java.util.Arrays;

/**
 * This approach uses min-heap to find the minimum element of all the first elements of all arrays, as opposed to linear comparison. So time complexity is O(nklog(k))
 * where n = number of elements in each array, k = number of arrays
 */
public class MergedSortedArrays {

	public static void main(String[] args) {
		int [][] arrays = new int[][] {
			{1, 10, 11, 15},
			{2, 4, 9, 14},
			{5, 6, 8, 16}			,
			{3, 7, 12, 13}
		};
		mergeSortedArrays(arrays, 4, 4);
	}
	
	private static void mergeSortedArrays(int [][] arrays, int k, int n) {
		int result [] = new int[k*n];
		int heap[] = new int[k];
		int arri[] = new int[k];
		int elei[] = new int[n];
		
		for (int i=0;i<k;i++) {
			heap[i] = arrays[i][0];
			arri[i] = i;
			elei[i] = 0;
		}
		
		for (int i=k/2-1;i>=0;i--) {
			heapify(heap, arri, elei, i, k, n, arrays);			
		}

		int i=0;
		while(true) {
			int min = heap[0];
			if (min == Integer.MAX_VALUE) break;
			result[i++] = min;
			
			int nindex = elei[arri[0]];
			if (nindex == n-1) {
				heap[0] = Integer.MAX_VALUE;
			} else {
				heap[0] = arrays[arri[0]][nindex+1];
				elei[arri[0]] = nindex+1;
			}
			
			heapify(heap, arri, elei, 0, k, n, arrays);
		}
		
		System.out.println(Arrays.toString(result));
	}
	
	private static void heapify(int [] heap, int [] arri, int [] elei, int root, int k, int n, int [][]arrays) {
		int smallest = root;
		int left = 2*root+1;
		int right = 2*root+2;
		
		if (left < k) {
			if (heap[left] < heap[smallest]) {
				smallest = left;
			}
		}
		
		if (right < k) {
			if (heap[right] < heap[smallest]) {
				smallest = right;
			}
		}
		
		if (smallest != root) {
			swap(heap, smallest, root);
			swap(arri, smallest, root);
			
			heapify(heap, arri, elei, smallest, k, n, arrays);
		}
	}
	
	private static void swap(int [] arr, int from, int to) {
		int temp = arr[from];
		arr[from] = arr[to];
		arr[to] = temp;
	}
}
