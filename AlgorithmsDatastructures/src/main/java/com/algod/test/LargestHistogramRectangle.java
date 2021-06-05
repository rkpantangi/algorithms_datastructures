package com.algod.test;

public class LargestHistogramRectangle {

	public static void main(String[] args) {
		int [] hist = new int[] {2, 1,5, 6, 2, 3};
		
		int marea = findLargestArea(hist, 0, hist.length-1, 0);
		System.out.println("Max area1 - " + marea);

		hist = new int[] {6, 2, 5, 4, 5, 1, 6};
		
		marea = findLargestArea(hist, 0, hist.length-1, 0);
		System.out.println("Max area2 - " + marea);

		hist = new int[] {1, 2, 3, 4, 5, 3, 3, 2};
		
		marea = findLargestArea(hist, 0, hist.length-1, 0);
		System.out.println("Max area3 - " + marea);
	}
	
	private static int findLargestArea(int [] hist, int st, int end, int marea) {
		int area=0;
		if (st == end) {
			area = Math.max(marea, hist[st]);
		} else {
			int minindex = findMin(hist, st, end);
			int area1 = (end - st + 1) * hist[minindex];
			int area2 = 0;
			if (st<=minindex-1) {
				area2 = findLargestArea(hist, st, minindex-1, marea);
			}
			int area3 = 0;
			if (minindex+1<=end) {
				area3 = findLargestArea(hist, minindex+1, end, marea);
			}
			area = Math.max(marea, Math.max(area1, Math.max(area2, area3)));
		}
		return area;
	}
	
	private static int findMin(int [] arr, int st, int end) {
		int min = arr[st];
		int minindex = st;
		for (int i=st+1;i<=end;i++) {
			if (arr[i] < min) {
				minindex = i;
				min = arr[i];
			}
		}
		return minindex;
	}

}
