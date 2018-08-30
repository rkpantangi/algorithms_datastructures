package com.algod.test.search;

/**
 * Sorted search, but no size on the input array is given.
 */
public class BinarySearchUnknownLength {

	public static void main(String[] args) {
		UnknownLengthArray ula = new UnknownLengthArray(new int[] {1,2,3,4,5,6,7,8,9});
		System.out.println(binarySearchNoLength(ula, 5));
		System.out.println(binarySearchNoLength(ula, 9));
		System.out.println(binarySearchNoLength(ula, 12));
		System.out.println(binarySearchNoLength(ula, 1));
		System.out.println(binarySearchNoLength(ula, 0));
	}
	
	private static int binarySearchNoLength(UnknownLengthArray ula, int elem) {
		// approximate the length
		if (ula.getElementAt(0) == -1) {
			return -1;
		}
		
		int index = 1;
		while(true) {
			if (ula.getElementAt(index) == -1) {
				break;
			}
			index *= 2;
		}
		
		return search(ula, elem, 0, index);
	}
	
	private static int search(UnknownLengthArray ula, int elem, int left, int right) {
		if (left > right) return -1;
		
		int mid = (left+right)/2;		
		
		int mide = ula.getElementAt(mid);
		if (mide == -1 || elem < mide) {
			return search(ula, elem, left, mid-1);
		} else if (mide < elem) {
			return search(ula, elem, mid+1, right);
		} else {
			return mid;
		}
	}

	private static class UnknownLengthArray {
		private int [] arr;
		
		public UnknownLengthArray(int [] arr) {
			this.arr = arr;
		}
		
		public int getElementAt(int i) {
			if (i >= arr.length) return  -1;
			return arr[i];
		}
	}
}
